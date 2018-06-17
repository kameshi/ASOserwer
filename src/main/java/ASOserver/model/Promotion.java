package ASOserver.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "PROMOTION")
public class Promotion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROMOTION_ID")
    private Long PromotionId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "DATE_FROM", nullable = false)
    private String dateFrom;
    @Column(name = "DATE_TO", nullable = false)
    private String dateTo;
    @Column(name = "PERCENT", nullable = false)
    private double percent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecificService> specificService;

    public Long getPromotionId() {
        return PromotionId;
    }

    public void setPromotionId(Long promotionId) {
        PromotionId = promotionId;
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

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
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

    public List<SpecificService> getSpecificService() {
        return specificService;
    }

    public void setSpecificService(List<SpecificService> specificService) {
        this.specificService = specificService;
    }

}