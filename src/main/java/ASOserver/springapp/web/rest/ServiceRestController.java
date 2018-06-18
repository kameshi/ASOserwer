package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.*;
import ASOserver.springapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/aso/rest/services")
public class ServiceRestController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceRestController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping()
    private ResponseEntity insertService(@RequestBody ServiceDTO serviceDTO) {
        try {
            this.serviceService.insertService(serviceDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    private ResponseEntity findServices() {
        try {
            List<ServiceDTO> services = serviceService.findServices();
            return new ResponseEntity(services, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{serviceId}")
    private ResponseEntity findService(@PathVariable Long serviceId) {
        try {
            ServiceDTO serviceDTO = serviceService.findServiceById(serviceId);
            return new ResponseEntity(serviceDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{serviceId}")
    private ResponseEntity updateService(@PathVariable Long serviceId, @RequestBody ServiceDTO serviceDTO) {
        try {
            serviceService.updateService(serviceId, serviceDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{serviceId}")
    private ResponseEntity deleteService(@PathVariable Long serviceId) {
        try {
            serviceService.deleteService(serviceId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
