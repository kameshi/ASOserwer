package ASOserver.configuration;

/**
 * Created by user on 2018-06-20.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//strona logowania
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity getAccountUserDTO() throws UnauthorizedException {
        AccountDTO accountDTO = new AccountDTO();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) (UserDetails) auth.getPrincipal();
            accountDTO.setLogin(userDetails.getUsername());
        }
        try {
            Account account = accountService.getAccountIdiCos(accountDTO.getLogin());
            accountDTO = AccountMapper.toAccountDTO(account);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return new ResponseEntity(accountDTO, HttpStatus.OK);
    }
}
