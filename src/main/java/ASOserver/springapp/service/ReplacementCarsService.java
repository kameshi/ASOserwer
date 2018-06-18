package ASOserver.springapp.service;

import ASOserver.model.ReplacementCars;
import ASOserver.springapp.dao.ReplacementCarsDAO;
import ASOserver.springapp.dto.ReplacementCarsDTO;
import ASOserver.springapp.mapper.ReplacementCarsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplacementCarsService {
    private final ReplacementCarsDAO replacementCarsDAO;

    @Autowired
    public ReplacementCarsService(ReplacementCarsDAO replacementCarsDAO) {
        this.replacementCarsDAO = replacementCarsDAO;
    }

    public void insertReplacementCars(ReplacementCarsDTO replacementCarsDTO) {
        this.replacementCarsDAO.save(ReplacementCarsMapper.toReplacementCars(replacementCarsDTO));
    }
    public void updateReplacementCars(Long replacementCarsId, ReplacementCarsDTO replacementCarsDTO) {
        replacementCarsDTO.setReplacementCarsId(replacementCarsId);
        this.replacementCarsDAO.save(ReplacementCarsMapper.toReplacementCars(replacementCarsDTO));
    }

    public void deleteReplacementCars(Long replacementCarsId) {
        this.replacementCarsDAO.deleteById(replacementCarsId);
    }

    public List<ReplacementCarsDTO> getReplacementCars() throws Exception {
        Iterable<ReplacementCars> replacementCarsIterable = this.replacementCarsDAO.findAll();
        List<ReplacementCarsDTO> replacementCarsDTOList = new ArrayList<>();
        for(ReplacementCars replacementCars : replacementCarsIterable){
            replacementCarsDTOList.add(ReplacementCarsMapper.toReplacementCarsDTO(replacementCars));
        }

        return replacementCarsDTOList;
    }

    public ReplacementCarsDTO findReplacementCarById(Long replacementCarId) throws Exception {
        return ReplacementCarsMapper.toReplacementCarsDTO(replacementCarsDAO.findById(replacementCarId).get());
    }
}
