package ASOserver.springapp.dto;

import java.io.Serializable;

public class PromotionDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String dateFrom;
    private String dateTo;
    private double percent;
    private ServiceDTO service;

    @Override
    public String toString() {
        return "PromotionDTO{" +
                "promotionId=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", percent=" + percent +
                ", service=" + service.toString() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ServiceDTO getService() {
        return service;
    }

    public void setService(ServiceDTO service) {
        this.service = service;
    }
}
