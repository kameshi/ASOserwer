package ASOserver.springapp.dto;

import ASOserver.model.enums.ServiceType;

import java.io.Serializable;

public class ServiceDTO implements Serializable{
    private Long id;
    private String name;
    private ServiceType.ServiceTypeEnum type;
    private double price;

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "serviceId=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
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

    public ServiceType.ServiceTypeEnum getType() {
        return type;
    }

    public void setType(ServiceType.ServiceTypeEnum type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
