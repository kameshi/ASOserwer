package ASOserver.springapp.web.rest;

import ASOserver.common.HashUtils;
import ASOserver.model.Employee;
import ASOserver.model.ReplacementVehicle;
import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.dto.ReplacementVehicleDTO;
import ASOserver.springapp.mapper.EmployeeMapper;
import ASOserver.springapp.service.AccountService;
import ASOserver.springapp.service.CustomerService;
import ASOserver.springapp.service.EmployeeService;
import ASOserver.springapp.service.ReplacementVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ASOserver/rest/replacementVehicle")
public class ReplacementVehicleRestController {

    private final ReplacementVehicleService replacementVehicleService;

    @Autowired
    public ReplacementVehicleRestController(ReplacementVehicleService replacementVehicleService) {
        this.replacementVehicleService = replacementVehicleService;
    }


    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertCategory(@RequestBody ReplacementVehicleDTO replacementVehicleDTO){
        try {
            this.replacementVehicleService.insertReplacementVehicle(replacementVehicleDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
