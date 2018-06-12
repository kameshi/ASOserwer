package ASOserver.springapp.dto;

import sun.misc.Queue;

import java.io.Serializable;

public class PartDTO implements Serializable {

    private Long PratId;
    private String name;
    private int quantity;
    private String price;
    private Queue<ServicePartDTO> servicePart;

    public Long getPratId() {
        return PratId;
    }

    public void setPratId(Long pratId) {
        PratId = pratId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Queue<ServicePartDTO> getServicePart() {
        return servicePart;
    }

    public void setServicePart(Queue<ServicePartDTO> servicePart) {
        this.servicePart = servicePart;
    }
}
