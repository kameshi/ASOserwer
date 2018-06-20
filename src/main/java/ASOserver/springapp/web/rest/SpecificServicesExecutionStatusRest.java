package ASOserver.springapp.web.rest;

import ASOserver.springapp.service.SpecificServicesExecutionStatusService;
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
@CrossOrigin(origins = "*")
@RequestMapping(value = "/aso/rest/SpecificServicesExecutionStatusRest")
public class SpecificServicesExecutionStatusRest {

    private final SpecificServicesExecutionStatusService specificServicesExecutionStatusService;

    @Autowired
    public SpecificServicesExecutionStatusRest(SpecificServicesExecutionStatusService specificServicesExecutionStatusService) {
        this.specificServicesExecutionStatusService = specificServicesExecutionStatusService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "specificServicesExecutionStatus")
    private ResponseEntity<Object> getSpecificServicesExecutionStatus(){
        try{
            List<String> specificServicesExecutionStatus = this.specificServicesExecutionStatusService.getSpecificServicesExecutionStatus();
            return new ResponseEntity<Object>(specificServicesExecutionStatus, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
