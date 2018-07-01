package ASOserver.springapp.service;

import ASOserver.model.Car;
import ASOserver.model.Customer;
import ASOserver.model.CustomerCar;
import ASOserver.springapp.dao.CustomerCarDAO;
import ASOserver.springapp.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCarService {
    private final CustomerCarDAO customerCarDAO;
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerCarService(CustomerCarDAO customerCarDAO, CustomerDAO customerDAO) {
        this.customerCarDAO = customerCarDAO;
        this.customerDAO = customerDAO;
    }

    public void insertCustomerCar(Customer customer, List<Car> cars) throws Exception {
        for(Car tmpCar : cars) {
            this.customerCarDAO.save(new CustomerCar(customer, tmpCar));
        }
    }

    public CustomerCar findCustomerCar(Long carId, Long customerId) {
        Customer customer = customerDAO.findById(customerId).get();
        for(CustomerCar customerCar : customer.getCustomerCars()) {
            if(customerCar.getCar().getCarId().equals(carId)) {
                return customerCar;
            }
        }
        return null;
    }
}
