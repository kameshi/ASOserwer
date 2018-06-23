package ASOserver.springapp.mapper;

import ASOserver.model.ReplacementCar;
import ASOserver.springapp.dto.ReplacementCarDTO;

public class ReplacementCarMapper {

    public static ReplacementCar toReplacementCar(ReplacementCarDTO replacementCarDTO){
        ReplacementCar replacementCar = new ReplacementCar();
        replacementCar.setReplacementCarId(replacementCarDTO.getId());
        replacementCar.setMake(replacementCarDTO.getMake());
        replacementCar.setModel(replacementCarDTO.getModel());
        replacementCar.setRegistrationNumber(replacementCarDTO.getRegistrationNumber());
        replacementCar.setVin(replacementCarDTO.getVin());
        return replacementCar;
    }

    public static ReplacementCarDTO toReplacementCarDTO(ReplacementCar replacementCar){
        ReplacementCarDTO replacementCarDTO = new ReplacementCarDTO();
        replacementCarDTO.setId(replacementCar.getReplacementCarId());
        replacementCarDTO.setMake(replacementCar.getMake());
        replacementCarDTO.setModel(replacementCar.getModel());
        replacementCarDTO.setRegistrationNumber(replacementCar.getRegistrationNumber());
        replacementCarDTO.setVin(replacementCar.getVin());
        return replacementCarDTO;
    }
}
