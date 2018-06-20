package ASOserver.springapp.web.rest;

import ASOserver.springapp.service.ServiceTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/aso/rest/service-types")
public class ServiceTypesRest {

    private final ServiceTypesService serviceTypesService;

    @Autowired
    public ServiceTypesRest(ServiceTypesService serviceTypesService) {
        this.serviceTypesService = serviceTypesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Object> getServiceTypes(){
        try{
            List<String> serviceTypes = this.serviceTypesService.getServiceTypes();
            return new ResponseEntity<Object>(serviceTypes, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
