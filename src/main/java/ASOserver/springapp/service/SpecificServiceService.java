package ASOserver.springapp.service;

import ASOserver.model.*;
import ASOserver.springapp.dao.*;
import ASOserver.springapp.dto.SpecificServiceDTO;
import ASOserver.springapp.mapper.SpecificServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecificServiceService {
    private final SpecificServiceDAO specificServiceDAO;
    private final EmployeeDAO employeeDAO;
    private final CustomerDAO customerDAO;
    private final CarsDAO carsDAO;

    @Autowired
    public SpecificServiceService(SpecificServiceDAO specificServiceDAO, EmployeeDAO employeeDAO, CustomerDAO customerDAO, CarsDAO carsDAO) {
        this.specificServiceDAO = specificServiceDAO;
        this.employeeDAO = employeeDAO;
        this.customerDAO = customerDAO;
        this.carsDAO = carsDAO;
    }

    public List<SpecificServiceDTO> findSpecificServices() throws Exception {
        Iterable<SpecificService> specificServiceIterable = this.specificServiceDAO.findAll();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();
        for(SpecificService tmpSpecificService : specificServiceIterable){
            specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
        }

        return specificServiceDTOList;
    }

    public SpecificServiceDTO findSpecificServiceById(Long specificServiceId) throws Exception {
        return SpecificServiceMapper.toSpecificServiceDTO(specificServiceDAO.findById(specificServiceId).get());
    }

    public void insertSpecificService(SpecificServiceDTO SpecificServiceDTO) throws Exception {
        this.specificServiceDAO.save(SpecificServiceMapper.toSpecificService(SpecificServiceDTO));
    }

    public void updateSpecificService(Long specificServiceId, SpecificServiceDTO specificServiceDTO) throws Exception {
        specificServiceDTO.setId(specificServiceId);
        specificServiceDAO.save(SpecificServiceMapper.toSpecificService(specificServiceDTO));
    }

    public void deleteSpecificService(Long specificServiceId) throws Exception {
        specificServiceDAO.deleteById(specificServiceId);
    }

    public List<SpecificServiceDTO> findSpecificServicesByEmployeeId(Long employeeId) throws Exception {
        Employee employee = employeeDAO.findById(employeeId).get();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();
        for(SpecificService tmpSpecificService : employee.getSpecificService()){
            specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
        }

        return specificServiceDTOList;
    }

    public List<SpecificServiceDTO> findSpecificServicesByCustomerId(Long customerId) throws Exception {
        Customer customer = customerDAO.findById(customerId).get();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();

        for(CustomerCars tmpCustomerCars : customer.getCustomerCars()) {
            for (SpecificService tmpSpecificService : tmpCustomerCars.getSpecificServices()) {
                specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
            }
        }

        return specificServiceDTOList;
    }

    public List<SpecificServiceDTO> findSpecificServicesByCarId(Long carId) throws Exception {
        Cars cars = carsDAO.findById(carId).get();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();

        for(CustomerCars tmpCustomerCars : cars.getCustomerCars()) {
            for (SpecificService tmpSpecificService : tmpCustomerCars.getSpecificServices()) {
                specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
            }
        }

        return specificServiceDTOList;
    }
}
