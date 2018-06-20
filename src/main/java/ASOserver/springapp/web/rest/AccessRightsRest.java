package ASOserver.springapp.web.rest;

import ASOserver.springapp.service.AccessRightsService;
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
@RequestMapping(value = "/aso/rest/access-right")
public class AccessRightsRest {

    private final AccessRightsService accessRightsService;

    @Autowired
    public AccessRightsRest(AccessRightsService accessRightsService) {
        this.accessRightsService = accessRightsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Object> getAccessRights(){
        try {
            List<String> accessRightsList = this.accessRightsService.getAccessRightsList();
            return new ResponseEntity<Object>(accessRightsList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
