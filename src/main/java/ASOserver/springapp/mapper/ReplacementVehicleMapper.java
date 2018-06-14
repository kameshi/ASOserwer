package ASOserver.springapp.mapper;

import ASOserver.model.ReplacementVehicle;
import ASOserver.springapp.dto.ReplacementVehicleDTO;

/**
 * Created by user on 2018-06-14.
 */
public class ReplacementVehicleMapper {
    public static ReplacementVehicle toReplacementVehicle(ReplacementVehicleDTO replacementVehicleDTO){
        ReplacementVehicle replacementVehicle = new ReplacementVehicle();
        replacementVehicle.setReplacementVehicleId(replacementVehicleDTO.getReplacementVehicleId());
        replacementVehicle.setMark(replacementVehicleDTO.getMark());
        replacementVehicle.setModel(replacementVehicleDTO.getModel());
        replacementVehicle.setRegistrationNumber(replacementVehicleDTO.getRegistrationNumber());
        replacementVehicle.setVin(replacementVehicleDTO.getVin());
        return replacementVehicle;
    }
    public static ReplacementVehicleDTO toReplacementVehicleDTO(ReplacementVehicle replacementVehicle){
        ReplacementVehicleDTO replacementVehicleDTO = new ReplacementVehicleDTO();
        replacementVehicleDTO.setReplacementVehicleId(replacementVehicle.getReplacementVehicleId());
        replacementVehicleDTO.setMark(replacementVehicle.getMark());
        replacementVehicleDTO.setModel(replacementVehicle.getModel());
        replacementVehicleDTO.setRegistrationNumber(replacementVehicle.getRegistrationNumber());
        replacementVehicleDTO.setVin(replacementVehicle.getVin());
        return replacementVehicleDTO;
    }
}
