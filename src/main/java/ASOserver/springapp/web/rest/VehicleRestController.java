package ASOserver.springapp.web.rest;

import ASOserver.common.HashUtils;
import ASOserver.model.Employee;
import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.dto.VehicleDTO;
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
    private ResponseEntity insertCategory(@RequestBody VehicleDTO vehicleDTO){
        try {
            System.out.println();
            System.out.println(vehicleDTO.toString());
            System.out.println();
            vehicleService.insertVehicle(vehicleDTO);
            System.out.println();
            System.out.println(vehicleDTO.toString());
            System.out.println();
            vehicleDTO.setVehicleId(vehicleService.getVehicleId(vehicleDTO.getVin()));
            System.out.println();
            System.out.println(vehicleDTO.toString());
            System.out.println();
            customerVehicleService.insertCustomerVehicle(vehicleDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
