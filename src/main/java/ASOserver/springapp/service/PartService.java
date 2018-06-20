package ASOserver.springapp.service;

import ASOserver.model.Part;
import ASOserver.springapp.dao.PartDAO;
import ASOserver.springapp.dto.PartDTO;
import ASOserver.springapp.mapper.PartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartService {
    private final PartDAO partDAO;

    @Autowired
    public PartService(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    public List<PartDTO> getParts() throws Exception {
        Iterable<Part> partIterable = this.partDAO.findAll();
        List<PartDTO> partDTOList = new ArrayList<>();
        for(Part part : partIterable){
            partDTOList.add(PartMapper.toPartDTO(part));
        }

        return partDTOList;
    }
    
    public void insertPart(PartDTO partDTO) throws Exception {
        this.partDAO.save(PartMapper.toPart(partDTO));
    }

    public PartDTO findPartById(Long partId) throws Exception {
        return PartMapper.toPartDTO(partDAO.findById(partId).get());
    }

    public void updatePart(Long partId, PartDTO partDTO) throws Exception {
        partDTO.setId(partId);
        partDAO.save(PartMapper.toPart(partDTO));
    }

    public void deletePart(Long partId) throws Exception {
        partDAO.deleteById(partId);
    }
}
