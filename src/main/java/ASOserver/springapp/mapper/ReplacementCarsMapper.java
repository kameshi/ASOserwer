package ASOserver.springapp.mapper;

import ASOserver.model.ReplacementCars;
import ASOserver.springapp.dto.ReplacementCarsDTO;

/**
 * Created by user on 2018-06-14.
 */
public class ReplacementCarsMapper {
    public static ReplacementCars toReplacementCars(ReplacementCarsDTO replacementCarsDTO){
        ReplacementCars replacementCars = new ReplacementCars();
        replacementCars.setReplacementCarsId(replacementCarsDTO.getReplacementCarsId());
        replacementCars.setMake(replacementCarsDTO.getMake());
        replacementCars.setModel(replacementCarsDTO.getModel());
        replacementCars.setRegistrationNumber(replacementCarsDTO.getRegistrationNumber());
        replacementCars.setVin(replacementCarsDTO.getVin());
        return replacementCars;
    }
    public static ReplacementCarsDTO toReplacementCarsDTO(ReplacementCars replacementCars){
        ReplacementCarsDTO replacementCarsDTO = new ReplacementCarsDTO();
        replacementCarsDTO.setReplacementCarsId(replacementCars.getReplacementCarsId());
        replacementCarsDTO.setMake(replacementCars.getMake());
        replacementCarsDTO.setModel(replacementCars.getModel());
        replacementCarsDTO.setRegistrationNumber(replacementCars.getRegistrationNumber());
        replacementCarsDTO.setVin(replacementCars.getVin());
        return replacementCarsDTO;
    }
}