package ASOserver.springapp.dto;

import sun.misc.Queue;

import java.io.Serializable;

public class ServiceDTO implements Serializable {

    private Long ServiceId;
    private String name;
    private String type;
    private int price;
    private Queue<PromotionDTO> promotion;
    private Queue<SpecificServiceDTO> specificService;

    public Long getServiceId() {
        return ServiceId;
    }

    public void setServiceId(Long serviceId) {
        ServiceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Queue<PromotionDTO> getPromotion() {
        return promotion;
    }

    public void setPromotion(Queue<PromotionDTO> promotion) {
        this.promotion = promotion;
    }

    public Queue<SpecificServiceDTO> getSpecificService() {
        return specificService;
    }

    public void setSpecificService(Queue<SpecificServiceDTO> specificService) {
        this.specificService = specificService;
    }
}
