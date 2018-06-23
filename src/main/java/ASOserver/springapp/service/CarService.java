package ASOserver.springapp.service;

import ASOserver.model.Car;
import ASOserver.model.Customer;
import ASOserver.model.CustomerCar;
import ASOserver.springapp.dao.CarDAO;
import ASOserver.springapp.dto.CarDTO;
import ASOserver.springapp.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final CarDAO carDAO;
    private final CustomerService customerService;

    @Autowired
    public CarService(CarDAO carDAO, CustomerService customerService) {
        this.carDAO = carDAO;
        this.customerService = customerService;
    }

    public void insertCars(CarDTO carDTO) {
        this.carDAO.save(CarMapper.toCars(carDTO));
    }

    public long getCarsId(String vin) throws Exception {
        return carDAO.findCarsIdByVin(vin);
    }

    public List<CarDTO> getCars() {
        Iterable<Car> carsIterable = this.carDAO.findAll();
        List<CarDTO> carDTOList = new ArrayList<>();
        for(Car car : carsIterable){
            carDTOList.add(CarMapper.toCarsDTO(car));
        }

        return carDTOList;
    }

    public CarDTO findCarById(Long carId) throws Exception {
        return CarMapper.toCarsDTO(carDAO.findById(carId).get());
    }

    public void updateCar(Long carId, CarDTO carDTO) throws Exception {
        carDTO.setId(carId);
        carDAO.save(CarMapper.toCars(carDTO));
    }

    public void deleteCar(Long carId) throws Exception {
        carDAO.deleteById(carId);
    }

    public List<CarDTO> findCarByCustomerId(Long customerId) throws Exception {
        Customer customer = customerService.getCustomer(customerId);
        List<CarDTO> cars = new ArrayList<>();
        for(CustomerCar tmpCustomerCar : customer.getCustomerCars()) {
            cars.add(CarMapper.toCarsDTO(tmpCustomerCar.getCar()));
        }
        return cars;
    }
}