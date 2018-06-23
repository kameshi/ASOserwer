package ASOserver.springapp.service;

import ASOserver.model.Car;
import ASOserver.model.Customer;
import ASOserver.model.CustomerCar;
import ASOserver.springapp.dao.CustomerCarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCarService {
    private final CustomerCarDAO customerCarDAO;

    @Autowired
    public CustomerCarService(CustomerCarDAO customerCarDAO) {
        this.customerCarDAO = customerCarDAO;
    }

    public void insertCustomerCar(Customer customer, List<Car> cars) throws Exception {
        for(Car tmpCar : cars) {
            this.customerCarDAO.save(new CustomerCar(customer, tmpCar));
        }
    }
}
