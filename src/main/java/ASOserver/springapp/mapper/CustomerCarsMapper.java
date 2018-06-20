package ASOserver.springapp.mapper;

import ASOserver.model.Customer;
import ASOserver.model.CustomerCars;
import ASOserver.model.Cars;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.CustomerCarsDTO;
import ASOserver.springapp.dto.CarsDTO;

/**
 * Created by user on 2018-06-14.
 */
public class CustomerCarsMapper {
    public static CustomerCars toCustomerCars(CarsDTO carsDTO){
        CustomerCars customerCars = new CustomerCars();
        customerCars.setCustomerCars((long) 1);
        customerCars.setCustomer(CustomerMapper.toCustomer(carsDTO.getCustomerDTO()));
        customerCars.setCars(CarsMapper.toCars(carsDTO));
        return customerCars;
    }
    public static CustomerCarsDTO toCustomerCarsDTO(CustomerCars customerCars){
        CustomerCarsDTO customerCarsDTO = new CustomerCarsDTO();
        customerCarsDTO.setCustomerCars((long) 1);
        customerCarsDTO.setCustomerDTO(CustomerMapper.toCustomerDTO(customerCars.getCustomer()));
        customerCarsDTO.setCarsDTO(CarsMapper.toCarsDTO(customerCars.getCars()));
        return customerCarsDTO;
    }
    public static CustomerCars toCustomerCars(CustomerCarsDTO customerCarsDTO){
        CustomerCars customerCars = new CustomerCars();
        customerCars.setCustomerCars((long) 1);
        customerCars.setCustomer(CustomerMapper.toCustomer(customerCarsDTO.getCustomerDTO()));
        customerCars.setCars(CarsMapper.toCars(customerCarsDTO.getCarsDTO()));
        return customerCars;
    }
}
