package ASOserver.springapp.mapper;

import ASOserver.model.CustomerCars;
import ASOserver.model.SpecificService;
import ASOserver.springapp.dto.SpecificServiceDTO;

public class SpecificServiceMapper {
    public static SpecificService toSpecificService(SpecificServiceDTO specificServiceDTO) {
        SpecificService specificService = new SpecificService();
        specificService.setSpecificServiceId(specificServiceDTO.getId());
        specificService.setService(ServiceMapper.toService(specificServiceDTO.getService()));
        specificService.setStartDate(specificServiceDTO.getStartDate());
        specificService.setEndDate(specificServiceDTO.getEndDate());
        specificService.setInsertDate(specificServiceDTO.getInsertionDate());
        specificService.setExecutionStatus(specificServiceDTO.getStatus().toString());
        specificService.setReplacementCars(ReplacementCarsMapper.toReplacementCars(specificServiceDTO.getReplacementCar()));
        specificService.setPromotion(PromotionMapper.toPromotion(specificServiceDTO.getPromotion()));
        specificService.setDescription(specificServiceDTO.getDescription());
        specificService.setEmployee(EmployeeMapper.toEmployee(specificServiceDTO.getEmployee()));
        specificService.setCustomerCars(new CustomerCars());
        specificService.getCustomerCars().setCars(CarsMapper.toCars(specificServiceDTO.getCar()));
        specificService.getCustomerCars().setCustomer(CustomerMapper.toCustomer(specificServiceDTO.getClient()));
        return specificService;
    }

    public static SpecificServiceDTO toSpecificServiceDTO(SpecificService specificService) {
        SpecificServiceDTO specificServiceDTO = new SpecificServiceDTO();
        specificServiceDTO.setId(specificService.getSpecificServiceId());
        specificServiceDTO.setService(ServiceMapper.toServiceDTO(specificService.getService()));
        specificServiceDTO.setStartDate(specificService.getStartDate());
        specificServiceDTO.setEndDate(specificService.getEndDate());
        specificServiceDTO.setInsertionDate(specificService.getInsertDate());
        specificServiceDTO.setStatus(specificService.getExecutionStatus());
        specificServiceDTO.setReplacementCar(ReplacementCarsMapper.toReplacementCarsDTO(specificService.getReplacementCars()));
        specificServiceDTO.setPromotion(PromotionMapper.toPromotionDTO(specificService.getPromotion()));
        specificServiceDTO.setDescription(specificService.getDescription());
        specificServiceDTO.setEmployee(EmployeeMapper.toEmployeeDTO(specificService.getEmployee()));
        specificServiceDTO.setCar(CarsMapper.toCarsDTO(specificService.getCustomerCars().getCars()));
        specificServiceDTO.setClient(CustomerMapper.toCustomerDTO(specificService.getCustomerCars().getCustomer()));
        return specificServiceDTO;
    }
}
