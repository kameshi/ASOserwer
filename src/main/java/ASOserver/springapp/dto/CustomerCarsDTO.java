package ASOserver.springapp.dto;

import java.io.Serializable;

public class CustomerCarsDTO implements Serializable {
    private Long id;
    private CustomerDTO customer;
    private CarsDTO cars;

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

    public CarsDTO getCars() {
        return cars;
    }

    public void setCars(CarsDTO cars) {
        this.cars = cars;
    }
}
