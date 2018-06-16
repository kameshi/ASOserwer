package ASOserver.springapp.web.rest;

import ASOserver.model.ChoiceList;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.mapper.EmployeeMapper;
import ASOserver.springapp.service.AccountService;
import ASOserver.springapp.service.CustomerService;
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
@RequestMapping(value = "/ASOserver/rest/account")
public class AccountRestController {
    private final AccountService accountService;
    private final CustomerService customerService;
    private final EmployeeService employerService;

    @Autowired
    public AccountRestController(AccountService accountService, CustomerService customerService, EmployeeService employerService) {
        this.accountService = accountService;
        this.customerService = customerService;
        this.employerService = employerService;
    }


    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertCategory(@RequestBody CustomerDTO customerDTO){
        try {
           this.accountService.insertAccount(customerDTO.getAccountDTO());
            customerDTO.getAccountDTO().setAccountId(accountService.getAccountId(customerDTO.getAccountDTO().getLogin()));
           if(customerDTO.getAccountDTO().getAccessRights().equals(ChoiceList.AccessRights.CUSTOMER.getAccessRights())){
               this.customerService.insertCustomer(customerDTO);
           }else{
               this.employerService.insertEmployee(EmployeeMapper.toEmployeeDTO(customerDTO));
           }
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
