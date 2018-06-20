package ASOserver.springapp.mapper;

import ASOserver.model.Service;
import ASOserver.springapp.dto.ServiceDTO;

/**
 * Created by user on 2018-06-14.
 */
public class ServiceMapper {
    public static Service toService(ServiceDTO serviceDTO){
        Service service = new Service();
        service.setServiceId(serviceDTO.getServiceId());
        service.setName(serviceDTO.getName());
        service.setPrice(serviceDTO.getPrice());
        service.setType(serviceDTO.getType());
        return service;
    }
    public static ServiceDTO toServiceDTO(Service service){
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setServiceId(service.getServiceId());
        serviceDTO.setName(service.getName());
        serviceDTO.setPrice(service.getPrice());
        serviceDTO.setType(service.getType());
        return serviceDTO;
    }
}
