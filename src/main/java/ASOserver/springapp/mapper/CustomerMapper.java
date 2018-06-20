package ASOserver.springapp.mapper;

import ASOserver.model.Customer;
import ASOserver.springapp.dto.CustomerDTO;

import java.util.stream.Collectors;

public class CustomerMapper {
    public static Customer toCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.seteMail(customerDTO.geteMail());
        customer.setPesel(customerDTO.getPesel());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAccount(new AccountMapper().toAccount(customerDTO.getAccount()));
        return customer;
    }

    public static CustomerDTO toCustomerDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.seteMail(customer.geteMail());
        customerDTO.setPesel(customer.getPesel());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setAccount(new AccountMapper().toAccountDTO(customer.getAccount()));
        customerDTO.setCars(customer.getCustomerCars().stream()
                .map(tmpCustomerCar -> CarsMapper.toCarsDTO(tmpCustomerCar.getCars()))
                .collect(Collectors.toList()));
        return customerDTO;
    }

    public static CustomerDTO toCustomerDTOWitchOutAccount(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.seteMail(customer.geteMail());
        customerDTO.setPesel(customer.getPesel());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setAccount(null);
        return customerDTO;
    }
}
