package ASOserver.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "SPECYFIC_SERVICE")
public class SpecificService{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SPECYFIC_SERVICE_ID")
    private Long SpecificServiceId;

    @Column(name = "START_DATE", nullable = false, unique = true)
    private String startDate;

    @Column(name = "END_DATE", nullable = false, unique = true)
    private String endDate;

    @Column(name = "INSERT_DATE", nullable = false, unique = true)
    private String insertDate;

    @Column(name = "EXECUTION_STATUS", nullable = false, unique = true)
    private String executionStatus;

    @Column(name = "REPLACEMENT_VEHICLE", nullable = false, unique = true)
    private String replacementVehicle;

    @Column(name = "DESCRIPTION", nullable = false, unique = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROMOTION_ID")
    private Promotion promotion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_VEHICLE_ID")
    private CustomerVehicle customerVehicle;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    @OneToMany(mappedBy = "specificService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Invoice> invoice;

    @OneToMany(mappedBy = "specificService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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