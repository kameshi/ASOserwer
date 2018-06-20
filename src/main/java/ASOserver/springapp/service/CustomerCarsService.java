package ASOserver.springapp.service;

/**
 * Created by user on 2018-06-14.
 */
import ASOserver.springapp.dao.CustomerCarsDAO;
import ASOserver.springapp.dto.CarsDTO;
import ASOserver.springapp.mapper.CustomerCarsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCarsService {

    private final CustomerCarsDAO customerCarsDAO;

    @Autowired
    public CustomerCarsService(CustomerCarsDAO customerCarsDAO) {
        this.customerCarsDAO = customerCarsDAO;
    }

    public void insertCustomerCars(CarsDTO carsDTO) throws Exception {
        this.customerCarsDAO.save(CustomerCarsMapper.toCustomerCars(carsDTO));
    }
}
