package ASOserver.springapp.dto;

import ASOserver.model.*;

import java.io.Serializable;
import java.util.List;

public class SpecificServiceDTO implements Serializable {

    private Long SpecificServiceId;
    private String startDate;
    private String endDate;
    private String insertDate;
    private String executionStatus;
    private String replacementVehicle;
    private String description;
    private Employee employee;
    private Promotion promotion;
    private CustomerVehicle customerVehicle;
    private Service service;
    private List<Invoice> invoice;
    private List<ServicePart> servicePart;

    public Long getSpecificServiceId() {
        return SpecificServiceId;
    }

    public void setSpecificServiceId(Long specificServiceId) {
        SpecificServiceId = specificServiceId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getReplacementVehicle() {
        return replacementVehicle;
    }

    public void setReplacementVehicle(String replacementVehicle) {
        this.replacementVehicle = replacementVehicle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public CustomerVehicle getCustomerVehicle() {
        return customerVehicle;
    }

    public void setCustomerVehicle(CustomerVehicle customerVehicle) {
        this.customerVehicle = customerVehicle;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    public List<ServicePart> getServicePart() {
        return servicePart;
    }

    public void setServicePart(List<ServicePart> servicePart) {
        this.servicePart = servicePart;
    }
}
