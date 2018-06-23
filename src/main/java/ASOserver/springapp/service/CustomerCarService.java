package ASOserver.springapp.service;

import ASOserver.springapp.dao.CustomerCarDAO;
import ASOserver.springapp.dto.CarDTO;
import ASOserver.springapp.mapper.CustomerCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCarService {
    private final CustomerCarDAO customerCarDAO;

    @Autowired
    public CustomerCarService(CustomerCarDAO customerCarDAO) {
        this.customerCarDAO = customerCarDAO;
    }

    public void insertCustomerCars(CarDTO carDTO) throws Exception {
        this.customerCarDAO.save(CustomerCarMapper.toCustomerCar(carDTO));
    }
}
