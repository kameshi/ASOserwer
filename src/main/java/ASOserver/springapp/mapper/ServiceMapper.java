package ASOserver.springapp.mapper;

import ASOserver.model.Service;
import ASOserver.model.enums.ServiceType;
import ASOserver.springapp.dto.ServiceDTO;

public class ServiceMapper {

    public static Service toService(ServiceDTO serviceDTO) {
        Service service = new Service();
        service.setServiceId(serviceDTO.getId());
        service.setName(serviceDTO.getName());
        service.setPrice(serviceDTO.getPrice());
        service.setType(serviceDTO.getType().getServiceType());
        return service;
    }

    public static ServiceDTO toServiceDTO(Service service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getServiceId());
        serviceDTO.setName(service.getName());
        serviceDTO.setPrice(service.getPrice());
        serviceDTO.setType(ServiceType.ServiceTypeEnum.valueOf(service.getType()));
        return serviceDTO;
    }
}
