package ASOserver.springapp.web.rest;

/**
 * Created by user on 2018-06-14.
 */

import ASOserver.common.HashUtils;
import ASOserver.model.Employee;
import ASOserver.model.ReplacementCars;
import ASOserver.springapp.dto.*;
import ASOserver.springapp.mapper.EmployeeMapper;
import ASOserver.springapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ASOserver/rest/Service")
public class ServiceRestController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceRestController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertCategory(@RequestBody ServiceDTO serviceDTO){
        try {
            this.serviceService.insertService(serviceDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
