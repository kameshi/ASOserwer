package ASOserver.springapp.service;

import ASOserver.model.Customer;
import ASOserver.springapp.dao.CustomerDAO;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer getCustomer(Long customerId) throws Exception {
        return customerDAO.findById(customerId).get();
    }

    public void insertCustomer(CustomerDTO customerDTO) throws Exception {
        this.customerDAO.save(CustomerMapper.toCustomer(customerDTO));
    }

    public void updateCustomer(Long customerId, CustomerDTO customerDTO) {
        customerDTO.setCustomerId(customerId);
        this.customerDAO.save(CustomerMapper.toCustomer(customerDTO));
    }

    public void deleteCustomer(Long customerId) {
        this.customerDAO.deleteById(customerId);
    }
}
