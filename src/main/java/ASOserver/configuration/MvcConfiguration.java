package ASOserver.configuration;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
    @Bean(name = "dataSource")
    public DriverManagerConnectionSource dataSource(){
        DriverManagerConnectionSource driverManagerConnectionSource = new DriverManagerConnectionSource();
        driverManagerConnectionSource.setDriverClass("oracle.jdbc.OracleDriver");
        driverManagerConnectionSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        driverManagerConnectionSource.setUser("hr");
        driverManagerConnectionSource.setPassword("hr");
        return driverManagerConnectionSource;
    }
}