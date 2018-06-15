package ASOserver.springapp.web.rest;

import ASOserver.springapp.service.ChoiceListService;
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
@RequestMapping(value = "/ASOserver/rest/choiceList")
public class ChoiceListRest {

    private final ChoiceListService choiceListService;



    @Autowired
    public ChoiceListRest(ChoiceListService choiceListService) {
        this.choiceListService = choiceListService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{accessRights}")
    private ResponseEntity<Object> getAccessRights(){
        try {
            List<String> accessRightsList = this.choiceListService.getAccessRightsList();
            return new ResponseEntity<Object>(accessRightsList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{notyficationTypes}")
    private ResponseEntity<Object> getNotyficationTypes(){
        try{
            List<String> notyficationTypesList = this.choiceListService.getNotyficationTypes();
            return new ResponseEntity<Object>(notyficationTypesList, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "specificServicesExecutionStatus")
    private ResponseEntity<Object> getSpecificServicesExecutionStatus(){
        try{
            List<String> specificServicesExecutionStatus = this.choiceListService.getSpecificServicesExecutionStatus();
            return new ResponseEntity<Object>(specificServicesExecutionStatus, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "paymentMethod")
    private ResponseEntity<Object> getPaymentMethod(){
        try{
            List<String> paymentMethod = this.choiceListService.getPaymentMethod();
            return new ResponseEntity<Object>(paymentMethod, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "serviceTypes")
    private ResponseEntity<Object> getServiceTypes(){
        try{
            List<String> serviceTypes = this.choiceListService.getServiceTypes();
            return new ResponseEntity<Object>(serviceTypes, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
