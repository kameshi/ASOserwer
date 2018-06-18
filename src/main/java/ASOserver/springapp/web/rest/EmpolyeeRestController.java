package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.dto.CarsDTO;
import ASOserver.springapp.service.CustomerService;
import ASOserver.springapp.service.EmployeeService;
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
@RequestMapping(value = "/ASOserver/rest/employees")
public class EmpolyeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmpolyeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Object> getEmployee(){
        try {
            List<EmployeeDTO> employeeDTOList = this.employeeService.getEmployee();
            return new ResponseEntity<Object>(employeeDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}