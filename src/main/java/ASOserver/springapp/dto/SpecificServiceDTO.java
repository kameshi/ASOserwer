package ASOserver.springapp.dto;

import ASOserver.model.SpecificServicesExecutionStatus;

import java.io.Serializable;
import java.sql.Date;

public class SpecificServiceDTO implements Serializable {
    private Long id;
    private ServiceDTO service;
    private Date startDate;
    private Date endDate;
    private Date insertionDate;
    private SpecificServicesExecutionStatus.SpecificServicesExecutionStatusEnum status;
    private ReplacementCarsDTO replacementCar;
    private PromotionDTO promotion;
    private String description;
    private EmployeeDTO employee;
    private CarsDTO car;
    private CustomerDTO client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceDTO getService() {
        return service;
    }

    public void setService(ServiceDTO service) {
        this.service = service;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }

    public SpecificServicesExecutionStatus.SpecificServicesExecutionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SpecificServicesExecutionStatus.SpecificServicesExecutionStatusEnum status) {
        this.status = status;
    }

    public ReplacementCarsDTO getReplacementCar() {
        return replacementCar;
    }

    public void setReplacementCar(ReplacementCarsDTO replacementCar) {
        this.replacementCar = replacementCar;
    }

    public PromotionDTO getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionDTO promotion) {
        this.promotion = promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public CarsDTO getCar() {
        return car;
    }

    public void setCar(CarsDTO car) {
        this.car = car;
    }

    public CustomerDTO getClient() {
        return client;
    }

    public void setClient(CustomerDTO client) {
        this.client = client;
    }
}
