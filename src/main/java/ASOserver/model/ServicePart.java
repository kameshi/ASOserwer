package ASOserver.model;

import javax.persistence.*;

@Entity
@Table(name = "SERVICE_PART")
public class ServicePart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICE_PART_ID")
    private Long servicePart;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "SPECYFIC_SERVICE_ID", referencedColumnName="SPECYFIC_SERVICE_ID")
    private SpecificService specificService;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "PART_ID", referencedColumnName="PART_ID")
    private Part part;

    public ServicePart() {
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