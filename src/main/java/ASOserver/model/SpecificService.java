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
}