package ASOserver.springapp.mapper;

import ASOserver.model.CustomerVehicle;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.VehicleDTO;

/**
 * Created by user on 2018-06-14.
 */
public class CustomerVehicleMapper {
    public static CustomerVehicle toCustomerVehicle(VehicleDTO vehicleDTO){
        CustomerVehicle customerVehicle = new CustomerVehicle();
        customerVehicle.setCustomerVehicle((long) 1);
        customerVehicle.setCustomer(CustomerMapper.toCustomer(vehicleDTO.getCustomerDTO()));
        customerVehicle.setVehicle(VehicleMapper.toVehicle(vehicleDTO));
        return customerVehicle;
    }
}
