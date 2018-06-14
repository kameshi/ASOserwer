package ASOserver.springapp.service;

import ASOserver.model.ReplacementVehicle;
import ASOserver.springapp.dao.ReplacementVehicleDAO;
import ASOserver.springapp.dto.ReplacementVehicleDTO;
import ASOserver.springapp.mapper.ReplacementVehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplacementVehicleService {
    private final ReplacementVehicleDAO replacementVehicleDAO;

    @Autowired
    public ReplacementVehicleService(ReplacementVehicleDAO replacementVehicleDAO) {
        this.replacementVehicleDAO = replacementVehicleDAO;
    }

    public ReplacementVehicle getReplacementVehicle(Long replacementVehicleId) throws Exception {
        return replacementVehicleDAO.findById(replacementVehicleId).get();
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
}
