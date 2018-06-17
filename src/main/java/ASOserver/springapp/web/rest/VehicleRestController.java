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
@RequestMapping(value = "/ASOserver/rest/vehicle")
public class VehicleRestController {
    private final VehicleService vehicleService;
    private final CustomerVehicleService customerVehicleService;

    @Autowired
    public VehicleRestController(VehicleService vehicleService, CustomerVehicleService customerVehicleService) {
        this.vehicleService = vehicleService;
        this.customerVehicleService = customerVehicleService;
    }


    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertVehicleDTO(@RequestBody VehicleDTO vehicleDTO){
        try {
            vehicleService.insertVehicle(vehicleDTO);
            vehicleDTO.setVehicleId(vehicleService.getVehicleId(vehicleDTO.getVin()));
            customerVehicleService.insertCustomerVehicle(vehicleDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Object> getVehicleDTO(){
        try {
            List<VehicleDTO> vehicleDTOList = this.vehicleService.getVehicle();
            return new ResponseEntity<Object>(vehicleDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{getVehicle}")
    private ResponseEntity<Object> getReplacementVehicle(){
        try {
            List<VehicleDTO> vehicleDTOList = this.vehicleService.getVehicle();
            return new ResponseEntity<Object>(vehicleDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
