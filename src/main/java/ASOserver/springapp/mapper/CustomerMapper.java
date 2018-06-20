package ASOserver.springapp.mapper;


import ASOserver.model.Customer;
import ASOserver.springapp.dto.CustomerDTO;

/**
 * Created by user on 2018-06-12.
 */
public class CustomerMapper {
    public static Customer toCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.seteMail(customerDTO.geteMail());
        customer.setPesel(customerDTO.getPesel());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAccount(new AccountMapper().toAccount(customerDTO.getAccountDTO()));
        customer.setAccount(new AccountMapper().toAccount(customerDTO.getAccountDTO()));
        return customer;
    }

    public static CustomerDTO toCustomerDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.seteMail(customer.geteMail());
        customerDTO.setPesel(customer.getPesel());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setAccountDTO(new AccountMapper().toAccountDTO(customer.getAccount()));
        customerDTO.setAccountDTO(new AccountMapper().toAccountDTO(customer.getAccount()));
        return customerDTO;
    }

    public static CustomerDTO toCustomerDTOWitchOutAccount(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.seteMail(customer.geteMail());
        customerDTO.setPesel(customer.getPesel());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setAccountDTO(null);
        return customerDTO;
    }
}
