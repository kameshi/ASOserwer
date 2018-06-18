package ASOserver.springapp.web.rest;

import ASOserver.common.HashUtils;
import ASOserver.model.Employee;
import ASOserver.springapp.dto.*;
import ASOserver.springapp.mapper.EmployeeMapper;
import ASOserver.springapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ASOserver/rest/cars")
public class CarsRestController {
    private final CarsService carsService;
    private final CustomerCarsService customerCarsService;

    @Autowired
    public CarsRestController(CarsService carsService, CustomerCarsService customerCarsService) {
        this.carsService = carsService;
        this.customerCarsService = customerCarsService;
    }


    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertCarsDTO(@RequestBody CarsDTO carsDTO){
        try {
            carsService.insertCars(carsDTO);
            carsDTO.setCarsId(carsService.getCarsId(carsDTO.getVin()));
            customerCarsService.insertCustomerCars(carsDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Object> getCarsDTO(){
        try {
            List<CarsDTO> carsDTOList = this.carsService.getCars();
            return new ResponseEntity<Object>(carsDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}