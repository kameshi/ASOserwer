package ASOserver.springapp.service;

import ASOserver.model.Car;
import ASOserver.model.Customer;
import ASOserver.model.CustomerCar;
import ASOserver.springapp.dao.CarDAO;
import ASOserver.springapp.dto.CarDTO;
import ASOserver.springapp.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarDAO carDAO;
    private final CustomerService customerService;

    @Autowired
    public CarService(CarDAO carDAO, @Lazy CustomerService customerService) {
        this.carDAO = carDAO;
        this.customerService = customerService;
    }

    public Car insertCar(CarDTO carDTO) {
        return this.carDAO.save(CarMapper.toCar(carDTO));
    }

    public List<Car> insertCars(List<CarDTO> carDTOS) {
        List<Car> carsToAdd = carDTOS.stream()
                .map(tmpCarDTO -> CarMapper.toCar(tmpCarDTO))
                .collect(Collectors.toList());

        List<Car> cars = new ArrayList<>();
        this.carDAO.saveAll(carsToAdd).forEach(tmpCar -> cars.add(tmpCar));
        return cars;
    }

    public List<CarDTO> checkAndFindCarsByVin(String vin) throws Exception {
        if(vin == null || vin.equals("")) {
            return getCars();
        }
        else {
            return findCarsByVin(vin);
        }
    }

    public List<CarDTO> findCarsByVin(String vin) throws Exception {
        Iterable<Car> carsIterable = carDAO.findCarByVin(vin);
        List<CarDTO> carDTOList = new ArrayList<>();
        for(Car car : carsIterable){
            carDTOList.add(CarMapper.toCarDTO(car));
        }
        return carDTOList;
    }

    public List<CarDTO> getCars() {
        Iterable<Car> carsIterable = this.carDAO.findAll();
        List<CarDTO> carDTOList = new ArrayList<>();
        for(Car car : carsIterable){
            carDTOList.add(CarMapper.toCarDTO(car));
        }

        return carDTOList;
    }

    public CarDTO findCarById(Long carId) throws Exception {
        return CarMapper.toCarDTO(carDAO.findById(carId).get());
    }

    public void updateCar(Long carId, CarDTO carDTO) throws Exception {
        carDTO.setId(carId);
        carDAO.save(CarMapper.toCar(carDTO));
    }

    public void deleteCar(Long carId) throws Exception {
        carDAO.deleteById(carId);
    }

    public List<CarDTO> findCarByCustomerId(Long customerId) throws Exception {
        Customer customer = customerService.getCustomer(customerId);
        List<CarDTO> cars = new ArrayList<>();
        for(CustomerCar tmpCustomerCar : customer.getCustomerCars()) {
            cars.add(CarMapper.toCarDTO(tmpCustomerCar.getCar()));
        }
        return cars;
    }
}