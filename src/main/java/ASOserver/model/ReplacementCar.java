package ASOserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "REPLACEMENT_CAR")
public class ReplacementCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPLACEMENT_CAR_ID")
    private Long replacementCarId;

    @Column(name = "MAKE")
    private String make;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "VIN")
    private String vin;

    @OneToMany(mappedBy = "replacementCar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecificService> specificServices;

    public ReplacementCar() {
    }

    public ReplacementCar(String make, String model, String registrationNumber, String vin) {
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.vin = vin;
    }

    public Long getReplacementCarId() {
        return replacementCarId;
    }

    public void setReplacementCarId(Long replacementCarId) {
        this.replacementCarId = replacementCarId;
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

    public List<SpecificService> getSpecificServices() {
        return specificServices;
    }

    public void setSpecificServices(List<SpecificService> specificServices) {
        this.specificServices = specificServices;
    }
}