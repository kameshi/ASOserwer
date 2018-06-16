package ASOserver.springapp.service;

import ASOserver.model.ReplacementVehicle;
import ASOserver.springapp.dao.ReplacementVehicleDAO;
import ASOserver.springapp.dto.ReplacementVehicleDTO;
import ASOserver.springapp.mapper.ReplacementVehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplacementVehicleService {
    private final ReplacementVehicleDAO replacementVehicleDAO;

    @Autowired
    public ReplacementVehicleService(ReplacementVehicleDAO replacementVehicleDAO) {
        this.replacementVehicleDAO = replacementVehicleDAO;
    }

    public void insertReplacementVehicle(ReplacementVehicleDTO replacementVehicleDTO) {
        this.replacementVehicleDAO.save(ReplacementVehicleMapper.toReplacementVehicle(replacementVehicleDTO));
    }
    public void updateReplacementVehicle(Long replacementVehicleId, ReplacementVehicleDTO replacementVehicleDTO) {
        replacementVehicleDTO.setReplacementVehicleId(replacementVehicleId);
        this.replacementVehicleDAO.save(ReplacementVehicleMapper.toReplacementVehicle(replacementVehicleDTO));
    }

    public void deleteReplacementVehicle(Long replacementVehicleId) {
        this.replacementVehicleDAO.deleteById(replacementVehicleId);
    }

    public List<ReplacementVehicleDTO> getReplacementVehicle() throws Exception {
        Iterable<ReplacementVehicle> replacementVehicleIterable = this.replacementVehicleDAO.findAll();
        List<ReplacementVehicleDTO> replacementVehicleDTOList = new ArrayList<>();
        for(ReplacementVehicle replacementVehicle : replacementVehicleIterable){
            replacementVehicleDTOList.add(ReplacementVehicleMapper.toReplacementVehicleDTO(replacementVehicle));
        }

        return replacementVehicleDTOList;
    }
}
