package ASOserver.springapp.dto;

import ASOserver.model.Customer;
import ASOserver.model.Vehicle;
import java.io.Serializable;

public class CustomerVehicleDTO implements Serializable{

    private Long customerVehicle;
    private Customer customer;
    private Vehicle vehicle;

    public Long getCustomerVehicle() {
        return customerVehicle;
    }

    public void setCustomerVehicle(Long customerVehicle) {
        this.customerVehicle = customerVehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
