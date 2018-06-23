package ASOserver.springapp.service;

import ASOserver.model.ReplacementCar;
import ASOserver.springapp.dao.ReplacementCarDAO;
import ASOserver.springapp.dto.ReplacementCarDTO;
import ASOserver.springapp.mapper.ReplacementCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplacementCarService {
    private final ReplacementCarDAO replacementCarDAO;

    @Autowired
    public ReplacementCarService(ReplacementCarDAO replacementCarDAO) {
        this.replacementCarDAO = replacementCarDAO;
    }

    public void insertReplacementCars(ReplacementCarDTO replacementCarDTO) {
        this.replacementCarDAO.save(ReplacementCarMapper.toReplacementCar(replacementCarDTO));
    }
    public void updateReplacementCars(Long replacementCarsId, ReplacementCarDTO replacementCarDTO) {
        replacementCarDTO.setId(replacementCarsId);
        this.replacementCarDAO.save(ReplacementCarMapper.toReplacementCar(replacementCarDTO));
    }

    public void deleteReplacementCars(Long replacementCarsId) {
        this.replacementCarDAO.deleteById(replacementCarsId);
    }

    public List<ReplacementCarDTO> getReplacementCars() throws Exception {
        Iterable<ReplacementCar> replacementCarsIterable = this.replacementCarDAO.findAll();
        List<ReplacementCarDTO> replacementCarDTOList = new ArrayList<>();
        for(ReplacementCar replacementCar : replacementCarsIterable){
            replacementCarDTOList.add(ReplacementCarMapper.toReplacementCarDTO(replacementCar));
        }

        return replacementCarDTOList;
    }

    public ReplacementCarDTO findReplacementCarById(Long replacementCarId) throws Exception {
        return ReplacementCarMapper.toReplacementCarDTO(replacementCarDAO.findById(replacementCarId).get());
    }
}
