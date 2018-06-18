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

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE", nullable = false)
    private String endDate;

    @Column(name = "INSERT_DATE", nullable = false)
    private String insertDate;

    @Column(name = "EXECUTION_STATUS", nullable = false)
    private String executionStatus;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROMOTION_ID")
    private Promotion promotion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_CARS_ID")
    private CustomerCars customerCars;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "REPLACMENT_CARS_ID", referencedColumnName="REPLACMENT_CARS_ID")
    private ReplacementCars replacementCars;

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

    public ReplacementCars getReplacementCars() {
        return replacementCars;
    }

    public void setReplacementCars(ReplacementCars replacementCars) {
        this.replacementCars = replacementCars;
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

    public CustomerCars getCustomerCars() {
        return customerCars;
    }

    public void setCustomerCars(CustomerCars customerCars) {
        this.customerCars = customerCars;
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