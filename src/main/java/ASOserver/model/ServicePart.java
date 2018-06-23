package ASOserver.model;

import javax.persistence.*;

@Entity
@Table(name = "SERVICE_PART")
public class ServicePart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICE_PART_ID")
    private Long servicePartId;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "SPECIFIC_SERVICE_ID", referencedColumnName="SPECIFIC_SERVICE_ID")
    private SpecificService specificService;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "PART_ID", referencedColumnName="PART_ID")
    private Part part;

    public ServicePart() {
    }

    public ServicePart(int quantity, SpecificService specificService, Part part) {
        this.quantity = quantity;
        this.specificService = specificService;
        this.part = part;
    }

    public Long getServicePartId() {
        return servicePartId;
    }

    public void setServicePartId(Long servicePartId) {
        this.servicePartId = servicePartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SpecificService getSpecificService() {
        return specificService;
    }

    public void setSpecificService(SpecificService specificService) {
        this.specificService = specificService;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}