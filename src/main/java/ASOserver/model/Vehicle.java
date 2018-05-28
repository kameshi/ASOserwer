package ASOserver.model;


import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.List;
@Entity
@Table(name = "VEHICLE")
public class Vehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VEHICLE_ID")
    private Long vehicleId;

    @Column(name = "MARK", nullable = false, unique = true)
    private String mark;

    @Column(name = "MODEL", nullable = false, unique = true)
    private String model;

    @Column(name = "REGISTRATION_NUMBER", nullable = false, unique = true)
    private String registrationNumber;

    @Column(name = "VIN", nullable = false, unique = true)
    private String vin;

    @Column(name = "CAPACITY", nullable = false, unique = true)
    private float  capacity;

    @Column(name = "POWER", nullable = false, unique = true)
    private float  power;

    @Column(name = "REVIEW_DATE", nullable = false, unique = true)
    private String reviewDate;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CustomerVehicle> customerVehicle;

    public Vehicle() {
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public List<CustomerVehicle> getCustomerVehicle() {
        return customerVehicle;
    }

    public void setCustomerVehicle(List<CustomerVehicle> customerVehicle) {
        this.customerVehicle = customerVehicle;
    }
}