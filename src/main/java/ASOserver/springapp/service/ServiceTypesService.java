package ASOserver.springapp.service;

import ASOserver.model.ServiceTypes;

import java.util.List;

public class ServiceTypesService {

    ServiceTypes serviceTypes = new ServiceTypes();

    public List<String> getServiceTypes() {
        List <String> serviceTypesList = serviceTypes.getServiceTypes();
        return serviceTypesList;
    }
}
