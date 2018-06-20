package ASOserver.springapp.service;

import ASOserver.springapp.dao.ServiceDAO;
import ASOserver.springapp.dto.ServiceDTO;
import ASOserver.springapp.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {
    private final ServiceDAO serviceDAO;

    @Autowired
    public ServiceService(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public void insertService(ServiceDTO serviceDTO) {
        this.serviceDAO.save(ServiceMapper.toService(serviceDTO));
    }

    public List<ServiceDTO> findServices() throws Exception {
        Iterable<ASOserver.model.Service> services = serviceDAO.findAll();
        List<ServiceDTO> serviceDTOS = new ArrayList<>();

        for(ASOserver.model.Service tmpService : services) {
            serviceDTOS.add(ServiceMapper.toServiceDTO(tmpService));
        }

        return serviceDTOS;
    }

    public ServiceDTO findServiceById(Long serviceId) throws Exception {
        return ServiceMapper.toServiceDTO(serviceDAO.findById(serviceId).get());
    }

    public void updateService(Long serviceId, ServiceDTO serviceDTO) throws Exception {
        serviceDTO.setServiceId(serviceId);
        serviceDAO.save(ServiceMapper.toService(serviceDTO));
    }

    public void deleteService(Long serviceId) throws Exception {
        serviceDAO.deleteById(serviceId);
    }
}
