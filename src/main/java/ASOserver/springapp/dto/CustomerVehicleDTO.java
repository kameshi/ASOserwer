package ASOserver.springapp.dto;

import ASOserver.model.Customer;
import ASOserver.model.Vehicle;

/**
 * Created by user on 2018-06-17.
 */
public class CustomerVehicleDTO {
    private Long customerVehicle;
    private CustomerDTO customerDTO;
    private VehicleDTO vehicleDTO;

    public Long getCustomerVehicle() {
        return customerVehicle;
    }

    public void setCustomerVehicle(Long customerVehicle) {
        this.customerVehicle = customerVehicle;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }
}
