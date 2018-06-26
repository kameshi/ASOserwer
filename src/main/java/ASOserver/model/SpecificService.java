package ASOserver.model;

import ASOserver.model.enums.SpecificServiceStatus;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "SPECIFIC_SERVICE")
public class SpecificService{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SPECIFIC_SERVICE_ID")
    private Long specificServiceId;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @Column(name = "INSERT_DATE", nullable = false)
    private Date insertDate;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "PROMOTION_ID")
    private Promotion promotion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "CUSTOMER_CAR_ID")
    private CustomerCar customerCar;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "REPLACEMENT_CAR_ID", referencedColumnName="REPLACEMENT_CAR_ID")
    private ReplacementCar replacementCar;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    @OneToMany(mappedBy = "specificService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "specificService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ServicePart> serviceParts;

    public SpecificService() {
    }

    public SpecificService(Date startDate, Date endDate, Date insertDate, String status, String description,
                           Employee employee, Promotion promotion, CustomerCar customerCar,
                           ReplacementCar replacementCar, Service service) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.insertDate = insertDate;
        this.status = status;
        this.description = description;
        this.employee = employee;
        this.promotion = promotion;
        this.customerCar = customerCar;
        this.replacementCar = replacementCar;
        this.service = service;
    }

    public Long getSpecificServiceId() {
        return specificServiceId;
    }

    public void setSpecificServiceId(Long specificServiceId) {
        this.specificServiceId = specificServiceId;
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

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReplacementCar getReplacementCar() {
        return replacementCar;
    }

    public void setReplacementCar(ReplacementCar replacementCar) {
        this.replacementCar = replacementCar;
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

    public CustomerCar getCustomerCar() {
        return customerCar;
    }

    public void setCustomerCar(CustomerCar customerCar) {
        this.customerCar = customerCar;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<ServicePart> getServiceParts() {
        return serviceParts;
    }

    public void setServiceParts(List<ServicePart> serviceParts) {
        this.serviceParts = serviceParts;
    }
}