package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/aso/rest/customers")
public class CustomerRestController {
    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    private ResponseEntity<Object> getCustomers(){
        try {
            List<CustomerDTO> customerDTOList = this.customerService.getCustomers();
            return new ResponseEntity<Object>(customerDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    private ResponseEntity insertCustomer(@RequestBody CustomerDTO customerDTO){
        try {
            this.customerService.insertCustomer(customerDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{customerId}")
    private ResponseEntity findCustomer(@PathVariable Long customerId) {
        try {
            CustomerDTO customerDTO = customerService.getCustomerDTO(customerId);
            return new ResponseEntity(customerDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{customerId}")
    private ResponseEntity updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) {
        try {
            customerService.updateCustomer(customerId, customerDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{customerId}")
    private ResponseEntity deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
