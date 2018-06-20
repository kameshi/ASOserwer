package ASOserver.springapp.service;

import ASOserver.model.Account;
import ASOserver.model.Employee;
import ASOserver.springapp.dao.EmployeeDAO;
import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService{
    private final EmployeeDAO employeeDAO;
    private final AccountService accountService;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO, AccountService accountService) {
        this.employeeDAO = employeeDAO;
        this.accountService = accountService;
    }

    public EmployeeDTO findEmployee(Long employeeId) throws Exception {
        return EmployeeMapper.toEmployeeDTO(employeeDAO.findById(employeeId).get());
    }

    public void insertEmployee(EmployeeDTO employeeDTO) throws Exception {
        Account account = this.accountService.insertAccount(employeeDTO.getAccount());
        Employee employee = EmployeeMapper.toEmployee(employeeDTO);
        employee.setAccount(account);
        this.employeeDAO.save(employee);
    }
    public void updateEmployee(Long employeeId, EmployeeDTO employeeDTO) throws Exception {
        employeeDTO.setId(employeeId);
        Account account = this.accountService.updateAccount(employeeDTO.getAccount().getId(), employeeDTO.getAccount());
        Employee employee = EmployeeMapper.toEmployee(employeeDTO);
        employee.setAccount(account);
        this.employeeDAO.save(EmployeeMapper.toEmployee(employeeDTO));
    }

    public void deleteEmployee(Long customerId) {
        this.employeeDAO.deleteById(customerId);
    }

    public List<EmployeeDTO> getEmployees() {
        Iterable<Employee> employeeIterable = this.employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Employee employee : employeeIterable){
            employeeDTOList.add(EmployeeMapper.toEmployeeDTO(employee));
        }
        return employeeDTOList;
    }
}
