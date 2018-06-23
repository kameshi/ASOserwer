package ASOserver.model;

import ASOserver.model.enums.ServiceType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SERVICE")
public class Service{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICE_ID")
    private Long serviceId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ServiceType.ServiceTypeEnum type;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @OneToOne(mappedBy = "service", fetch = FetchType.LAZY)
    private Promotion promotion;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecificService> specificServices;

    public Service() {
    }

    public Service(String name, ServiceType.ServiceTypeEnum type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
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

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<SpecificService> getSpecificServices() {
        return specificServices;
    }

    public void setSpecificServices(List<SpecificService> specificServices) {
        this.specificServices = specificServices;
    }
}