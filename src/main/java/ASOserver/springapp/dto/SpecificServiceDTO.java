package ASOserver.springapp.dto;

import ASOserver.model.enums.SpecificServiceStatus;

import java.io.Serializable;
import java.sql.Date;

public class SpecificServiceDTO implements Serializable {
    private Long id;
    private ServiceDTO service;
    private Date startDate;
    private Date endDate;
    private Date insertionDate;
    private SpecificServiceStatus.SpecificServiceStatusEnum status;
    private ReplacementCarDTO replacementCar;
    private PromotionDTO promotion;
    private String description;
    private EmployeeDTO employee;
    private CarDTO car;
    private CustomerDTO client;
    private InvoiceDTO invoice;

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

    public SpecificServiceStatus.SpecificServiceStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SpecificServiceStatus.SpecificServiceStatusEnum status) {
        this.status = status;
    }

    public ReplacementCarDTO getReplacementCar() {
        return replacementCar;
    }

    public void setReplacementCar(ReplacementCarDTO replacementCar) {
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

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public CustomerDTO getClient() {
        return client;
    }

    public void setClient(CustomerDTO client) {
        this.client = client;
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }
}
