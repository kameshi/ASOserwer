package ASOserver.springapp.web.rest;

import ASOserver.springapp.service.NotyficationTypesService;
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
@RequestMapping(value = "/aso/rest/NotyficationTypesRest")
public class NotyficationTypesRest {

    private final NotyficationTypesService notyficationTypesService;

    @Autowired
    public NotyficationTypesRest(NotyficationTypesService notyficationTypesService) {
        this.notyficationTypesService = notyficationTypesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Object> getNotyficationTypes(){
        try{
            List<String> notyficationTypesList = this.notyficationTypesService.getNotyficationTypes();
            return new ResponseEntity<Object>(notyficationTypesList, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
