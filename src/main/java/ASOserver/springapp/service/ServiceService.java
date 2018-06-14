package ASOserver.springapp.service;

/**
 * Created by user on 2018-06-14.
 */

import ASOserver.springapp.dao.ReplacementVehicleDAO;
import ASOserver.springapp.dao.ServiceDAO;
import ASOserver.springapp.dto.ServiceDTO;
import ASOserver.springapp.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
