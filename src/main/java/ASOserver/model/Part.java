package ASOserver.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "PART")
public class Part{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PART_ID")
    private Long PratId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @OneToMany(mappedBy = "part", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ServicePart> servicePart;

    public Part() {
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ServicePart> getServicePart() {
        return servicePart;
    }

    public void setServicePart(List<ServicePart> servicePart) {
        this.servicePart = servicePart;
    }
}