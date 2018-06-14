package ASOserver.springapp.dto;

import ASOserver.model.Service;

import java.io.Serializable;

/**
 * Created by user on 2018-06-14.
 */
public class PromotionDTO implements Serializable {
    private Long promotionId;
    private String name;
    private String description;
    private String dateFrom;
    private String dateTo;
    private double percent;
    private ServiceDTO serviceDTO;

    @Override
    public String toString() {
        return "PromotionDTO{" +
                "promotionId=" + promotionId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", percent=" + percent +
                ", service=" + serviceDTO.toString() +
                '}';
    }

    public ServiceDTO getServiceDTO() {
        return serviceDTO;
    }

    public void setServiceDTO(ServiceDTO serviceDTO) {
        this.serviceDTO = serviceDTO;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        promotionId = promotionId;
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
}
