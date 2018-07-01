package ASOserver.springapp.dto;

import java.io.Serializable;

public class PartDTO implements Serializable {

    private Long id;
    private String name;
    private Integer quantity;
    private double price;

    @Override
    public String toString() {
        return "PartDTO{" +
                "PratId=" + id +
                ", name='" + name + '\'' +
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
