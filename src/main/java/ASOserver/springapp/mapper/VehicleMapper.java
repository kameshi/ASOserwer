package ASOserver.springapp.mapper;

import ASOserver.model.Vehicle;
import ASOserver.springapp.dto.VehicleDTO;

/**
 * Created by user on 2018-06-14.
 */
public class VehicleMapper {

    public static Vehicle toVehicle(VehicleDTO vehicleDTO){
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(vehicleDTO.getVehicleId());
        vehicle.setMark(vehicleDTO.getMark());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        vehicle.setVin(vehicleDTO.getVin());
        vehicle.setCapacity(vehicleDTO.getCapacity());
        vehicle.setPower(vehicleDTO.getPower());
        vehicle.setReviewDate(vehicleDTO.getReviewDate());
        return vehicle;
    }
}
