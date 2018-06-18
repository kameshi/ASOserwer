package ASOserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "REPLACMENT_CARS")
public class ReplacementCars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPLACMENT_CARS_ID")
    private Long replacementCarsId;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MARK")
    private String make;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "VIN")
    private String vin;

    @OneToMany(mappedBy = "replacementCars", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecificService> specificService;

    public List<SpecificService> getSpecificService() {
        return specificService;
    }

    public void setSpecificService(List<SpecificService> specificService) {
        this.specificService = specificService;
    }

    public ReplacementCars() {
    }

    public Long getReplacementCarsId() {
        return replacementCarsId;
    }

    public void setReplacementCarsId(Long replacementCarsId) {
        this.replacementCarsId = replacementCarsId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}