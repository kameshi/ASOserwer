package ASOserver.springapp.dto;

import sun.misc.Queue;
import java.io.Serializable;

public class PromotionDTO implements Serializable {

    private Long PromotionId;
    private String name;
    private String description;
    private String dateFrom;
    private String dateTo;
    private double percent;
    private ServiceDTO service;
    private Queue<SpecificServiceDTO> specificService;

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

    public ServiceDTO getService() {
        return service;
    }

    public void setService(ServiceDTO service) {
        this.service = service;
    }

    public Queue<SpecificServiceDTO> getSpecificService() {
        return specificService;
    }

    public void setSpecificService(Queue<SpecificServiceDTO> specificService) {
        this.specificService = specificService;
    }
}
