package ASOserver.springapp.dto;

import ASOserver.model.Customer;

import java.io.Serializable;

public class CustomerReplacementVehicleDTO implements Serializable{

    private Long customerReplacementVehicle;
    private Customer customer;
    private ReplacementVehicleDTO replacementVehicle;

    public Long getCustomerReplacementVehicle() {
        return customerReplacementVehicle;
    }

    public void setCustomerReplacementVehicle(Long customerReplacementVehicle) {
        this.customerReplacementVehicle = customerReplacementVehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ReplacementVehicleDTO getReplacementVehicle() {
        return replacementVehicle;
    }

    public void setReplacementVehicle(ReplacementVehicleDTO replacementVehicle) {
        this.replacementVehicle = replacementVehicle;
    }
}
