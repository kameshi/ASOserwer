package ASOserver.springapp.service;

import ASOserver.model.Employee;
import ASOserver.springapp.dao.EmployeeDAO;
import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService{
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee getEmployee(Long employeeId) throws Exception {
        return employeeDAO.findById(employeeId).get();
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
}
