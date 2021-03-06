package ASOserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PART")
public class Part{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PART_ID")
    private Long partId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @OneToMany(mappedBy = "part", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ServicePart> serviceParts;

    public Part() {
    }

    public Part(String name, Integer quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
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

    public List<ServicePart> getServiceParts() {
        return serviceParts;
    }

    public void setServiceParts(List<ServicePart> serviceParts) {
        this.serviceParts = serviceParts;
    }
}