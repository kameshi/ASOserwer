package ASOserver;

import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.service.AccountService;
import ASOserver.springapp.service.CustomerService;
import ASOserver.springapp.web.rest.AccountRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        AccountDTO  accountDTO = new AccountDTO();
        accountDTO.setAccountId((long)1);
        accountDTO.setLogin("karol");
        accountDTO.setPassword("karol");
        accountDTO.setAccessRights("Kierownik");

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId((long)1);
        customerDTO.setName("karol");
        customerDTO.setSurname("marchewka");
        customerDTO.seteMail("karol@op.pl");
        customerDTO.setPesel("12332112312");
        customerDTO.setPhoneNumber("222333111");
        customerDTO.setAccountDTO(accountDTO);

    }
}
