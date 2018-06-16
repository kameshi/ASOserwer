package ASOserver.springapp.mapper;

import ASOserver.model.Customer;
import ASOserver.model.Employee;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.EmployeeDTO;

/**
 * Created by user on 2018-06-13.
 */
public class EmployeeMapper {
    public static Employee toEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.seteMail(employeeDTO.geteMail());
        employee.setPesel(employeeDTO.getPesel());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setAccount(new AccountMapper().toAccount(employeeDTO.getAccountDTO()));
        return employee;
    }

    public static EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.seteMail(employee.geteMail());
        employeeDTO.setPesel(employee.getPesel());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setAccountDTO(new AccountMapper().toAccountDTO(employee.getAccount()));
        return employeeDTO;
    }

    public static EmployeeDTO toEmployeeDTO(CustomerDTO customerDTO){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(customerDTO.getCustomerId());
        employeeDTO.setName(customerDTO.getName());
        employeeDTO.setSurname(customerDTO.getSurname());
        employeeDTO.seteMail(customerDTO.geteMail());
        employeeDTO.setPesel(customerDTO.getPesel());
        employeeDTO.setPhoneNumber(customerDTO.getPhoneNumber());
        employeeDTO.setAccountDTO(customerDTO.getAccountDTO());
        return employeeDTO;
    }

    public static EmployeeDTO toEmployeeDTOWitchOutAccount(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.seteMail(employee.geteMail());
        employeeDTO.setPesel(employee.getPesel());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setAccountDTO(null);
        return employeeDTO;
    }
}
