package ASOserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "REPLACMENT_VEHICLE")
public class ReplacementVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPLACMENT_VEHICLE_ID")
    private Long replacementVehicleId;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MARK")
    private String mark;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "VIN")
    private String vin;

    @OneToMany(mappedBy = "replacementVehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CustomerReplacementVehicle> customerReplacementVehicle;

    public List<CustomerReplacementVehicle> getCustomerReplacementVehicle() {
        return customerReplacementVehicle;
    }

    public void setCustomerReplacementVehicle(List<CustomerReplacementVehicle> customerReplacementVehicle) {
        this.customerReplacementVehicle = customerReplacementVehicle;
    }

    public ReplacementVehicle() {
    }

    public Long getReplacementVehicleId() {
        return replacementVehicleId;
    }

    public void setReplacementVehicleId(Long replacementVehicleId) {
        this.replacementVehicleId = replacementVehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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