package ASOserver.springapp.service;

import ASOserver.model.Account;
import ASOserver.model.Car;
import ASOserver.model.Customer;
import ASOserver.model.enums.AccessRight;
import ASOserver.springapp.dao.CustomerDAO;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;
    private final AccountService accountService;
    private final CarService carService;
    private final CustomerCarService customerCarService;

    @Autowired
    public CustomerService(CustomerDAO customerDAO, AccountService accountService, CarService carService, CustomerCarService customerCarService) {
        this.customerDAO = customerDAO;
        this.accountService = accountService;
        this.carService = carService;
        this.customerCarService = customerCarService;
    }

    public Customer getCustomer(Long customerId) throws Exception {
        return customerDAO.findById(customerId).get();
    }

    public CustomerDTO getCustomerDTO(Long customerId) throws Exception {
        return CustomerMapper.toCustomerDTO(customerDAO.findById(customerId).get());
    }

    public CustomerDTO findCustomerByAccountId(Long accountId) throws Exception {
        Account account = accountService.getAccount(accountId);
        if(account.getCustomer() == null)
            throw new NoSuchElementException();

        return CustomerMapper.toCustomerDTO(account.getCustomer());
    }

    public void insertCustomer(CustomerDTO customerDTO) throws Exception {
        customerDTO.getAccount().setAccessRight(AccessRight.AccessRightEnum.CUSTOMER);
        Account account = this.accountService.insertAccount(customerDTO.getAccount());
        Customer customer = CustomerMapper.toCustomer(customerDTO);
        customer.setAccount(account);
        Customer addedCustomer = customerDAO.save(customer);
        List<Car> cars = carService.insertCars(customerDTO.getCars());
        customerCarService.insertCustomerCar(addedCustomer, cars);
    }

    public void updateCustomer(Long customerId, CustomerDTO customerDTO) throws Exception {
        customerDTO.setId(customerId);
        customerDTO.getAccount().setAccessRight(AccessRight.AccessRightEnum.CUSTOMER);
        Account account = this.accountService.updateAccount(customerDTO.getAccount().getId(), customerDTO.getAccount());
        Customer customer = CustomerMapper.toCustomer(customerDTO);
        customer.setAccount(account);
        Customer updatedCustomer = customerDAO.save(customer);
        List<Car> cars = carService.insertCars(customerDTO.getCars().stream()
                .filter(tmpCar -> tmpCar.getId() == null)
                .collect(Collectors.toList()));
        customerCarService.insertCustomerCar(updatedCustomer, cars);
    }

    public void deleteCustomer(Long customerId) {
        Customer customer = customerDAO.findById(customerId).get();
        accountService.disableAccount(customer.getAccount());
        //this.customerDAO.deleteById(customerId);
    }

    public List<CustomerDTO> getCustomers() {
        Iterable<Customer> customerIterable = this.customerDAO.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer : customerIterable){
            if(customer.getAccount().getEnable()) {
                customerDTOList.add(CustomerMapper.toCustomerDTO(customer));
            }
        }
        return customerDTOList;
    }

}
