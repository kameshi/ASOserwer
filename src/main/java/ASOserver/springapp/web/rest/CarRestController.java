package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.CarDTO;
import ASOserver.springapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/aso/rest/cars")
public class CarRestController {
    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertCar(@RequestBody CarDTO carDTO) {
        try {
            carService.insertCar(carDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity getCars(){
        try {
            List<CarDTO> carDTOList = this.carService.getCars();
            return new ResponseEntity(carDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{carId}")
    private ResponseEntity findCar(@PathVariable Long carId) {
        try {
            CarDTO carDTO = carService.findCarById(carId);
            return new ResponseEntity(carDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{carId}")
    private ResponseEntity updateCar(@PathVariable Long carId, @RequestBody CarDTO carDTO) {
        try {
            carService.updateCar(carId, carDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{carId}")
    private ResponseEntity deleteCar(@PathVariable Long carId) {
        try {
            carService.deleteCar(carId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/customers/{customerId}")
    private ResponseEntity findCarByCustomerId(@PathVariable Long customerId) {
        try {
            List<CarDTO> carDTOS = carService.findCarByCustomerId(customerId);
            return new ResponseEntity(carDTOS, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/vin/{vin}")
    private ResponseEntity findCarsByVin(@PathVariable String vin) {
        try {
            List<CarDTO> carDTOS = carService.checkAndFindCarsByVin(vin);
            return new ResponseEntity(carDTOS, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
