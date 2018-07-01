package ASOserver.configuration;

import ASOserver.model.enums.AccessRight;
import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.service.AccountService;
import ch.qos.logback.core.db.DriverManagerConnectionSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT a.login AS USERNAME, a.password AS PASSWORD , a.enable as ENABLED FROM Account a WHERE a.login=?")
                .authoritiesByUsernameQuery("SELECT a.login AS USERNAME, a.ACCESS_RIGHT AS ROLE FROM Account a WHERE a.login =?  ");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/aso/rest/cars").hasAnyRole("klient", "biurowy", "administrator")
                .antMatchers("/aso/rest/cars").hasAnyRole("biurowy", "administrator")
                .antMatchers("/aso/rest/customers").hasAnyRole("biurowy", "administrator")
                .antMatchers("/aso/rest/employees").hasAnyRole("biurowy", "administrator")
                .antMatchers("/aso/rest/notification-types").hasAnyRole("biurowy", "administrator")
                .antMatchers("/aso/rest/parts").hasAnyRole("biurowy", "administrator")
                .antMatchers("/aso/rest/promotions").hasAnyRole("biurowy", "administrator")
                .antMatchers("/aso/rest/replacement-cars").hasAnyRole("biurowy", "administrator")
                .antMatchers(HttpMethod.GET, "/aso/rest/services").hasAnyRole("klient", "biurowy", "administrator")
                .antMatchers("/aso/rest/services/serviceId").hasAnyRole("biurowy", "administrator", "mechanik")
                .antMatchers("/aso/rest/services").hasAnyRole("biurowy", "administrator", "mechanik")
                .antMatchers("/aso/rest/specific-services-statuses").hasAnyRole("biurowy", "administrator")
                .antMatchers("/aso/rest/service-positions").hasAnyRole("biurowy", "administrator")
                .antMatchers("/aso/rest/notifications").hasAnyRole("biurowy", "administrator")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("http://localhost:4200/")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}