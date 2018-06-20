package ASOserver.springapp.mapper;

import ASOserver.model.Cars;
import ASOserver.springapp.dto.CarsDTO;

public class CarsMapper {

    public static Cars toCars(CarsDTO carsDTO){
        Cars cars = new Cars();
        cars.setCarsId(carsDTO.getId());
        cars.setMake(carsDTO.getMake());
        cars.setModel(carsDTO.getModel());
        cars.setRegistrationNumber(carsDTO.getRegistrationNumber());
        cars.setVin(carsDTO.getVin());
        cars.setCapacity(carsDTO.getCapacity());
        cars.setPower(carsDTO.getPower());
        cars.setReviewDate(carsDTO.getReviewDate());
        return cars;
    }

    public static CarsDTO toCarsDTO(Cars cars) {
        CarsDTO carsDTO = new CarsDTO();
        carsDTO.setId(cars.getCarsId());
        carsDTO.setMake(cars.getMake());
        carsDTO.setModel(cars.getModel());
        carsDTO.setRegistrationNumber(cars.getRegistrationNumber());
        carsDTO.setVin(cars.getVin());
        carsDTO.setCapacity(cars.getCapacity());
        carsDTO.setPower(cars.getPower());
        carsDTO.setReviewDate(cars.getReviewDate());
        return carsDTO;
    }
}
