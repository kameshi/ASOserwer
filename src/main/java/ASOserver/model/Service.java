package ASOserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SERVICE")
public class Service{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICE_ID")
    private Long ServiceId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @OneToOne(mappedBy = "service", fetch = FetchType.LAZY)
    private Promotion promotion;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecificService> specificService;

    public Service() {
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<SpecificService> getSpecificService() {
        return specificService;
    }

    public void setSpecificService(List<SpecificService> specificService) {
        this.specificService = specificService;
    }
}