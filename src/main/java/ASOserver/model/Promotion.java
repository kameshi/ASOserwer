package ASOserver.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "PROMOTION")
public class Promotion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROMOTION_ID")
    private Long promotionId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "DATE_FROM", nullable = false)
    private Date dateFrom;

    @Column(name = "DATE_TO", nullable = false)
    private Date dateTo;

    @Column(name = "PERCENT", nullable = false)
    private double percent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecificService> specificServices;

    public Promotion() {
    }

    public Promotion(String name, String description, Date dateFrom, Date dateTo, double percent, Service service) {
        this.name = name;
        this.description = description;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.percent = percent;
        this.service = service;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<SpecificService> getSpecificServices() {
        return specificServices;
    }

    public void setSpecificServices(List<SpecificService> specificServices) {
        this.specificServices = specificServices;
    }
}