package ASOserver.springapp.service.enums;

import ASOserver.model.enums.ServiceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypesService {
    ServiceType serviceType = new ServiceType();

    public List<String> getServiceTypes() {
        List <String> serviceTypesList = serviceType.getServiceTypes();
        return serviceTypesList;
    }
}
