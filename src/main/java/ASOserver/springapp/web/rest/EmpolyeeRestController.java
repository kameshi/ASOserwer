package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/aso/rest/employees")
public class EmpolyeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmpolyeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping()
    private ResponseEntity insertEmployee(@RequestBody EmployeeDTO employeeDTO){
        try {
            employeeService.insertEmployee(employeeDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    private ResponseEntity<Object> getEmployees(){
        try {
            List<EmployeeDTO> employeeDTOList = this.employeeService.getEmployees();
            return new ResponseEntity<Object>(employeeDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{employeeId}")
    private ResponseEntity findEmployee(@PathVariable Long employeeId) {
        try {
            EmployeeDTO employeeDTO = employeeService.findEmployee(employeeId);
            return new ResponseEntity(employeeDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{employeeId}")
    private ResponseEntity updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.updateEmployee(employeeId, employeeDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{employeeId}")
    private ResponseEntity deleteEmployee(@PathVariable Long employeeId) {
        try {
            employeeService.deleteEmployee(employeeId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}