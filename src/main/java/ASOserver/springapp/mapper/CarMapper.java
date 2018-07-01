package ASOserver.springapp.mapper;

import ASOserver.model.Car;
import ASOserver.springapp.dto.CarDTO;

public class CarMapper {

    public static Car toCar(CarDTO carDTO){
        Car car = new Car();
        car.setCarId(carDTO.getId());
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setRegistrationNumber(carDTO.getRegistrationNumber());
        car.setVin(carDTO.getVin());
        car.setCapacity(carDTO.getEngineSize());
        car.setPower(carDTO.getEnginePower());
        car.setReviewDate(carDTO.getReviewDate());
        return car;
    }

    public static CarDTO toCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getCarId());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setRegistrationNumber(car.getRegistrationNumber());
        carDTO.setVin(car.getVin());
        carDTO.setEngineSize(car.getCapacity());
        carDTO.setEnginePower(car.getPower());
        carDTO.setReviewDate(car.getReviewDate());
        carDTO.setCustomer(CustomerMapper.toCustomerDTO(car.getCustomerCars().stream().findFirst().get().getCustomer()));
        return carDTO;
    }

    public static CarDTO toCarDTOWithoutCustomer(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getCarId());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setRegistrationNumber(car.getRegistrationNumber());
        carDTO.setVin(car.getVin());
        carDTO.setEngineSize(car.getCapacity());
        carDTO.setEnginePower(car.getPower());
        carDTO.setReviewDate(car.getReviewDate());
        return carDTO;
    }
}
