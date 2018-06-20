package ASOserver.springapp.service;

import ASOserver.model.SpecificService;
import ASOserver.model.SpecificServicesExecutionStatus;
import ASOserver.springapp.dao.CarsDAO;
import ASOserver.springapp.dao.CustomerDAO;
import ASOserver.springapp.dao.EmployeeDAO;
import ASOserver.springapp.dao.SpecificServiceDAO;
import ASOserver.springapp.dto.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final SpecificServiceDAO specificServiceDAO;
    private final CarsDAO carsDAO;
    private final EmployeeDAO employeeDAO;
    private final CustomerDAO customerDAO;

    @Autowired
    public DashboardService(SpecificServiceDAO specificServiceDAO, CarsDAO carsDAO, EmployeeDAO employeeDAO, CustomerDAO customerDAO) {
        this.specificServiceDAO = specificServiceDAO;
        this.carsDAO = carsDAO;
        this.employeeDAO = employeeDAO;
        this.customerDAO = customerDAO;
    }

    public DashboardDTO getStats() throws Exception {
        DashboardDTO dashboardDTO = new DashboardDTO();
        dashboardDTO.setEmployeesCount(countEmployees());
        dashboardDTO.setClientsCount(countClients());
        dashboardDTO.setCarsCount(countCars());
        dashboardDTO.setServicesCount(countSpecificServices());
        countSpecificServicesByStatus(dashboardDTO);
        return dashboardDTO;
    }

    private long countEmployees() throws Exception {
        return employeeDAO.count();
    }

    private long countClients() throws Exception {
        return customerDAO.count();
    }

    private long countCars() throws Exception {
        return carsDAO.count();
    }

    private long countSpecificServices() throws Exception {
        return specificServiceDAO.count();
    }

    private void countSpecificServicesByStatus(DashboardDTO dashboardDTO) throws Exception {
        long newServices = 0, activeServices = 0, finishedServices = 0;
        for(SpecificService tmpSpecificService : specificServiceDAO.findAll()) {
            if(tmpSpecificService.getExecutionStatus().equals(SpecificServicesExecutionStatus.SpecificServicesExecutionStatusEnum.NEW.getSpecificServicesExecutionStatus())) {
                newServices++;
            }
            else if(tmpSpecificService.getExecutionStatus().equals(SpecificServicesExecutionStatus.SpecificServicesExecutionStatusEnum.DURING.getSpecificServicesExecutionStatus())) {
                activeServices++;
            }
            else if(tmpSpecificService.getExecutionStatus().equals(SpecificServicesExecutionStatus.SpecificServicesExecutionStatusEnum.FINISHED.getSpecificServicesExecutionStatus())) {
                finishedServices++;
            }
        }

        dashboardDTO.setNewServicesCount(newServices);
        dashboardDTO.setActiveServicesCount(activeServices);
        dashboardDTO.setFinishedServicesCount(finishedServices);
    }
}
