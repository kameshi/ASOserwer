package ASOserver.springapp.service;

import ASOserver.model.Cars;
import ASOserver.model.Customer;
import ASOserver.model.CustomerCars;
import ASOserver.springapp.dao.CarsDAO;
import ASOserver.springapp.dto.CarsDTO;
import ASOserver.springapp.mapper.CarsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarsService {
    private final CarsDAO carsDAO;
    private final CustomerService customerService;

    @Autowired
    public CarsService(CarsDAO carsDAO, CustomerService customerService) {
        this.carsDAO = carsDAO;
        this.customerService = customerService;
    }

    public void insertCars(CarsDTO carsDTO) {
        this.carsDAO.save(CarsMapper.toCars(carsDTO));
    }

    public long getCarsId(String vin) throws Exception {
        return carsDAO.findCarsIdByVin(vin);
    }

    public List<CarsDTO> getCars() {
        Iterable<Cars> carsIterable = this.carsDAO.findAll();
        List<CarsDTO> carsDTOList = new ArrayList<>();
        for(Cars cars : carsIterable){
            carsDTOList.add(CarsMapper.toCarsDTO(cars));
        }

        return carsDTOList;
    }

    public CarsDTO findCarById(Long carId) throws Exception {
        return CarsMapper.toCarsDTO(carsDAO.findById(carId).get());
    }

    public void updateCar(Long carId, CarsDTO carDTO) throws Exception {
        carDTO.setId(carId);
        carsDAO.save(CarsMapper.toCars(carDTO));
    }

    public void deleteCar(Long carId) throws Exception {
        carsDAO.deleteById(carId);
    }

    public List<CarsDTO> findCarByCustomerId(Long customerId) throws Exception {
        Customer customer = customerService.getCustomer(customerId);
        List<CarsDTO> cars = new ArrayList<>();
        for(CustomerCars tmpCustomerCar : customer.getCustomerCars()) {
            cars.add(CarsMapper.toCarsDTO(tmpCustomerCar.getCars()));
        }
        return cars;
    }
}