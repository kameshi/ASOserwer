package ASOserver.springapp.dto;

import ASOserver.model.Customer;
import ASOserver.model.Cars;

/**
 * Created by user on 2018-06-17.
 */
public class CustomerCarsDTO {
    private Long customerCars;
    private CustomerDTO customerDTO;
    private CarsDTO carsDTO;

    public Long getCustomerCars() {
        return customerCars;
    }

    public void setCustomerCars(Long customerCars) {
        this.customerCars = customerCars;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public CarsDTO getCarsDTO() {
        return carsDTO;
    }

    public void setCarsDTO(CarsDTO carsDTO) {
        this.carsDTO = carsDTO;
    }
}
