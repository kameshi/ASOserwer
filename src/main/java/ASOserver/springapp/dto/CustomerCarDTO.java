package ASOserver.springapp.dto;

import java.io.Serializable;

public class CustomerCarDTO implements Serializable {
    private Long id;
    private CustomerDTO customer;
    private CarDTO car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public CarDTO getCars() {
        return car;
    }

    public void setCars(CarDTO car) {
        this.car = car;
    }
}
