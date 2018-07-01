package ASOserver.springapp.service;

import ASOserver.model.SpecificService;
import ASOserver.model.enums.SpecificServiceStatus;
import ASOserver.springapp.dao.CarDAO;
import ASOserver.springapp.dao.CustomerDAO;
import ASOserver.springapp.dao.EmployeeDAO;
import ASOserver.springapp.dao.SpecificServiceDAO;
import ASOserver.springapp.dto.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final SpecificServiceDAO specificServiceDAO;
    private final CarDAO carDAO;
    private final EmployeeDAO employeeDAO;
    private final CustomerDAO customerDAO;

    @Autowired
    public DashboardService(SpecificServiceDAO specificServiceDAO, CarDAO carDAO, EmployeeDAO employeeDAO, CustomerDAO customerDAO) {
        this.specificServiceDAO = specificServiceDAO;
        this.carDAO = carDAO;
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
        return carDAO.count();
    }

    private long countSpecificServices() throws Exception {
        return specificServiceDAO.count();
    }

    private void countSpecificServicesByStatus(DashboardDTO dashboardDTO) throws Exception {
        long newServices = 0, activeServices = 0, finishedServices = 0;
        for(SpecificService tmpSpecificService : specificServiceDAO.findAll()) {
            if(tmpSpecificService.getStatus().equals(SpecificServiceStatus.SpecificServiceStatusEnum.NEW.getSpecificServiceStatus())) {
                newServices++;
            }
            else if(tmpSpecificService.getStatus().equals(SpecificServiceStatus.SpecificServiceStatusEnum.DURING.getSpecificServiceStatus())) {
                activeServices++;
            }
            else if(tmpSpecificService.getStatus().equals(SpecificServiceStatus.SpecificServiceStatusEnum.FINISHED.getSpecificServiceStatus())) {
                finishedServices++;
            }
        }

        dashboardDTO.setNewServicesCount(newServices);
        dashboardDTO.setActiveServicesCount(activeServices);
        dashboardDTO.setFinishedServicesCount(finishedServices);
    }
}