package ASOserver.springapp.service;

import ASOserver.model.ServiceTypes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypesService {

    ServiceTypes serviceTypes = new ServiceTypes();

    public List<String> getServiceTypes() {
        List <String> serviceTypesList = serviceTypes.getServiceTypes();
        return serviceTypesList;
    }
}
