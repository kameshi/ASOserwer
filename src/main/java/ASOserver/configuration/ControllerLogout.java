package ASOserver.configuration;

/**
 * Created by user on 2018-06-20.
 */

import ASOserver.model.Account;
import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.mapper.AccountMapper;
import ASOserver.springapp.service.AccountService;
import ASOserver.springapp.service.CustomerService;
import ASOserver.springapp.service.EmployeeService;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin(origins = "*")
public class ControllerLogout {

    private final AccountService accountService;
    private final CustomerService customerService;
    private final EmployeeService employerService;

    @Autowired
    public ControllerLogout(AccountService accountService, CustomerService customerService, EmployeeService employerService) {
        this.accountService = accountService;
        this.customerService = customerService;
        this.employerService = employerService;
    }

    @RequestMapping(value="/aso/rest/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "/login";//strona logowania
    }
    @RequestMapping(value = "/aso/rest/get", method = RequestMethod.GET)
    public ResponseEntity getAccountUserDTO() throws UnauthorizedException {
        AccountDTO accountDTO = new AccountDTO();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            accountDTO.setLogin(userDetails.getUsername());
        }
        try {
            Account account = accountService.getAccountIdiCos(accountDTO.getLogin());
            accountDTO = AccountMapper.toAccountDTO(account);
            if(!accountDTO.getLogin().equals(null)){
                return new ResponseEntity(accountDTO, HttpStatus.OK);
            }else {
                return new ResponseEntity(accountDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(accountDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
