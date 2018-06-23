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
    private final CarDAO carDAO;

    @Autowired
    public SpecificServiceService(SpecificServiceDAO specificServiceDAO, EmployeeDAO employeeDAO, CustomerDAO customerDAO, CarDAO carDAO) {
        this.specificServiceDAO = specificServiceDAO;
        this.employeeDAO = employeeDAO;
        this.customerDAO = customerDAO;
        this.carDAO = carDAO;
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

        for(CustomerCar tmpCustomerCar : customer.getCustomerCars()) {
            for (SpecificService tmpSpecificService : tmpCustomerCar.getSpecificServices()) {
                specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
            }
        }

        return specificServiceDTOList;
    }

    public List<SpecificServiceDTO> findSpecificServicesByCarId(Long carId) throws Exception {
        Car car = carDAO.findById(carId).get();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();

        for(CustomerCar tmpCustomerCar : car.getCustomerCars()) {
            for (SpecificService tmpSpecificService : tmpCustomerCar.getSpecificServices()) {
                specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
            }
        }

        return specificServiceDTOList;
    }
}
