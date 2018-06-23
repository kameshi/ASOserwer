package ASOserver.configuration;

import ASOserver.model.AccessRights;
import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * Created by user on 2018-06-20.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private AccountService accountService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/aso/rest/AccessRightsRest/accessRights").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())//AccessRights.AccessRightsEnum.ADMINISTRATOR//nie wiem dokładnie bedzei w bzie
                .antMatchers(HttpMethod.GET, "/aso/rest/cars").permitAll()
                .antMatchers("/aso/rest/cars").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .antMatchers("/aso/rest/customers").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .antMatchers("/aso/rest/employer").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .antMatchers("/aso/rest/NotyficationTypesRest").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .antMatchers("/aso/rest/parts").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .antMatchers("/aso/rest/promotion").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .antMatchers("/aso/rest/replacement-cars").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .antMatchers(HttpMethod.GET, "/aso/rest/services").permitAll()
                .antMatchers("/aso/rest/services").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .antMatchers("/aso/rest/SpecificServicesExecutionStatusRest").hasRole(AccessRights.AccessRightsEnum.OFFICEWORKER.getAccessRights())
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("http://localhost:4200/")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable();


    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        List<AccountDTO> accountList = accountService.getAccountDTO();
        for(int i = 0; i < accountList.size(); ++i) {
            auth
                    .inMemoryAuthentication()
                    .withUser(accountList.get(i).getLogin()).password(accountList.get(i).getPassword()).roles(accountList.get(i).getAccessRights());
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}