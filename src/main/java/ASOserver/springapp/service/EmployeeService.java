package ASOserver.springapp.service;

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

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public EmployeeDTO findEmployee(Long employeeId) throws Exception {
        return EmployeeMapper.toEmployeeDTO(employeeDAO.findById(employeeId).get());
    }

    public void insertEmployee(EmployeeDTO employeeDTO) {
        this.employeeDAO.save(EmployeeMapper.toEmployee(employeeDTO));
    }
    public void updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeId(employeeId);
        this.employeeDAO.save(EmployeeMapper.toEmployee(employeeDTO));
    }

    public void deleteEmployee(Long customerId) {
        this.employeeDAO.deleteById(customerId);
    }

    public List<EmployeeDTO> getEmployees() {
        Iterable<Employee> employeeIterable = this.employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Employee employee : employeeIterable){
            employeeDTOList.add(EmployeeMapper.toEmployeeDTOWitchOutAccount(employee));
        }
        return employeeDTOList;
    }
}
