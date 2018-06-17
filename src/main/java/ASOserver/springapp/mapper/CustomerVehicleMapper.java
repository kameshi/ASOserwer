package ASOserver.springapp.mapper;

import ASOserver.model.Customer;
import ASOserver.model.CustomerVehicle;
import ASOserver.model.Vehicle;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.CustomerVehicleDTO;
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
    public static CustomerVehicleDTO toCustomerVehicleDTO(CustomerVehicle customerVehicle){
        CustomerVehicleDTO customerVehicleDTO = new CustomerVehicleDTO();
        customerVehicleDTO.setCustomerVehicle((long) 1);
        customerVehicleDTO.setCustomerDTO(CustomerMapper.toCustomerDTO(customerVehicle.getCustomer()));
        customerVehicleDTO.setVehicleDTO(VehicleMapper.toVehicleDTO(customerVehicle.getVehicle()));
        return customerVehicleDTO;
    }
    public static CustomerVehicle toCustomerVehicle(CustomerVehicleDTO customerVehicleDTO){
        CustomerVehicle customerVehicle = new CustomerVehicle();
        customerVehicle.setCustomerVehicle((long) 1);
        customerVehicle.setCustomer(CustomerMapper.toCustomer(customerVehicleDTO.getCustomerDTO()));
        customerVehicle.setVehicle(VehicleMapper.toVehicle(customerVehicleDTO.getVehicleDTO()));
        return customerVehicle;
    }
}
