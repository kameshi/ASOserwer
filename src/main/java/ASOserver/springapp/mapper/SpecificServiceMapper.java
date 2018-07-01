package ASOserver.springapp.mapper;

import ASOserver.model.CustomerCar;
import ASOserver.model.SpecificService;
import ASOserver.model.enums.SpecificServiceStatus;
import ASOserver.springapp.dto.SpecificServiceDTO;

public class SpecificServiceMapper {

    public static SpecificService toSpecificService(SpecificServiceDTO specificServiceDTO) {
        SpecificService specificService = new SpecificService();
        specificService.setSpecificServiceId(specificServiceDTO.getId());
        if(specificServiceDTO.getService() != null)
            specificService.setService(ServiceMapper.toService(specificServiceDTO.getService()));
        specificService.setStartDate(specificServiceDTO.getStartDate());
        specificService.setEndDate(specificServiceDTO.getEndDate());
        specificService.setInsertDate(specificServiceDTO.getInsertionDate());
        specificService.setStatus(specificServiceDTO.getStatus().getSpecificServiceStatus());
        if(specificServiceDTO.getReplacementCar() != null)
            specificService.setReplacementCar(ReplacementCarMapper.toReplacementCar(specificServiceDTO.getReplacementCar()));
        if(specificServiceDTO.getPromotion() != null)
            specificService.setPromotion(PromotionMapper.toPromotion(specificServiceDTO.getPromotion()));
        specificService.setDescription(specificServiceDTO.getDescription());
        specificService.setEmployee(EmployeeMapper.toEmployee(specificServiceDTO.getEmployee()));
        specificService.setCustomerCar(new CustomerCar());
        specificService.getCustomerCar().setCar(CarMapper.toCar(specificServiceDTO.getCar()));
        specificService.getCustomerCar().setCustomer(CustomerMapper.toCustomer(specificServiceDTO.getClient()));
        return specificService;
    }

    public static SpecificServiceDTO toSpecificServiceDTO(SpecificService specificService) {
        SpecificServiceDTO specificServiceDTO = new SpecificServiceDTO();
        specificServiceDTO.setId(specificService.getSpecificServiceId());
        specificServiceDTO.setService(ServiceMapper.toServiceDTO(specificService.getService()));
        specificServiceDTO.setStartDate(specificService.getStartDate());
        specificServiceDTO.setEndDate(specificService.getEndDate());
        specificServiceDTO.setInsertionDate(specificService.getInsertDate());
        specificServiceDTO.setStatus(SpecificServiceStatus.SpecificServiceStatusEnum.getSpecificServiceStatus(specificService.getStatus()));
        specificServiceDTO.setReplacementCar(ReplacementCarMapper.toReplacementCarDTO(specificService.getReplacementCar()));
        specificServiceDTO.setPromotion(PromotionMapper.toPromotionDTO(specificService.getPromotion()));
        specificServiceDTO.setDescription(specificService.getDescription());
        specificServiceDTO.setEmployee(EmployeeMapper.toEmployeeDTO(specificService.getEmployee()));
        specificServiceDTO.setCar(CarMapper.toCarDTO(specificService.getCustomerCar().getCar()));
        specificServiceDTO.setClient(CustomerMapper.toCustomerDTO(specificService.getCustomerCar().getCustomer()));
        return specificServiceDTO;
    }
}