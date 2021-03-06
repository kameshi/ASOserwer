package ASOserver.springapp.mapper;

import ASOserver.model.CustomerCar;
import ASOserver.springapp.dto.CarDTO;
import ASOserver.springapp.dto.CustomerCarDTO;

public class CustomerCarMapper {

    public static CustomerCar toCustomerCar(CarDTO carDTO){
        CustomerCar customerCar = new CustomerCar();
        customerCar.setCustomerCarId((long) 1);
        customerCar.setCustomer(CustomerMapper.toCustomer(carDTO.getCustomer()));
        customerCar.setCar(CarMapper.toCar(carDTO));
        return customerCar;
    }

    public static CustomerCarDTO toCustomerCarDTO(CustomerCar customerCar){
        CustomerCarDTO customerCarDTO = new CustomerCarDTO();
        customerCarDTO.setId((long) 1);
        customerCarDTO.setCustomer(CustomerMapper.toCustomerDTO(customerCar.getCustomer()));
        customerCarDTO.setCars(CarMapper.toCarDTO(customerCar.getCar()));
        return customerCarDTO;
    }

    public static CustomerCar toCustomerCar(CustomerCarDTO customerCarDTO){
        CustomerCar customerCar = new CustomerCar();
        customerCar.setCustomerCarId((long) 1);
        customerCar.setCustomer(CustomerMapper.toCustomer(customerCarDTO.getCustomer()));
        customerCar.setCar(CarMapper.toCar(customerCarDTO.getCars()));
        return customerCar;
    }
}
