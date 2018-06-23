package ASOserver.springapp.mapper;

import ASOserver.model.Employee;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.EmployeeDTO;

public class EmployeeMapper {

    public static Employee toEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.seteMail(employeeDTO.getEmail());
        employee.setPesel(employeeDTO.getPesel());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setAccount(AccountMapper.toAccount(employeeDTO.getAccount()));
        return employee;
    }

    public static EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getEmployeeId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setEmail(employee.geteMail());
        employeeDTO.setPesel(employee.getPesel());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setAccount(AccountMapper.toAccountDTO(employee.getAccount()));
        return employeeDTO;
    }

    public static EmployeeDTO toEmployeeDTO(CustomerDTO customerDTO){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(customerDTO.getId());
        employeeDTO.setName(customerDTO.getName());
        employeeDTO.setSurname(customerDTO.getSurname());
        employeeDTO.setEmail(customerDTO.getEmail());
        employeeDTO.setPesel(customerDTO.getPesel());
        employeeDTO.setPhoneNumber(customerDTO.getPhoneNumber());
        employeeDTO.setAccount(customerDTO.getAccount());
        return employeeDTO;
    }

    public static EmployeeDTO toEmployeeDTOWitchOutAccount(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getEmployeeId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setEmail(employee.geteMail());
        employeeDTO.setPesel(employee.getPesel());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setAccount(null);
        return employeeDTO;
    }
}
