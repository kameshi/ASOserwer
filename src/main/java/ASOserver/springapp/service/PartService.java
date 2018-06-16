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

    public List<PartDTO> getPart() throws Exception {
        Iterable<Part> partIterable = this.partDAO.findAll();
        List<PartDTO> partDTOList = new ArrayList<>();
        for(Part part : partIterable){
            partDTOList.add(PartMapper.toPartDTO(part));
        }

        return partDTOList;
    }

}
