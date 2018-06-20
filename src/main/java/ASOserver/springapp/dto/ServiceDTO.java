package ASOserver.springapp.dto;

import java.io.Serializable;

/**
 * Created by user on 2018-06-14.
 */
public class ServiceDTO implements Serializable{
    private Long serviceId;
    private String name;
    private String type;
    private double price;

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
