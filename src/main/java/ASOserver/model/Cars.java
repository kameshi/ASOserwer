package ASOserver.model;


import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.List;
@Entity
@Table(name = "CARS")
public class Cars{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CARS_ID")
    private Long carsId;

    @Column(name = "MARK", nullable = false)
    private String make;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "REGISTRATION_NUMBER", nullable = false, unique = true)
    private String registrationNumber;

    @Column(name = "VIN", nullable = false, unique = true)
    private String vin;

    @Column(name = "CAPACITY", nullable = false)
    private float  capacity;

    @Column(name = "POWER", nullable = false)
    private float  power;

    @Column(name = "REVIEW_DATE", nullable = false)
    private String reviewDate;

    @OneToMany(mappedBy = "cars", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CustomerCars> customerCars;

    public Cars() {
    }

    public Long getCarsId() {
        return carsId;
    }

    public void setCarsId(Long carsId) {
        this.carsId = carsId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
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

    public List<CustomerCars> getCustomerCars() {
        return customerCars;
    }

    public void setCustomerCars(List<CustomerCars> customerCars) {
        this.customerCars = customerCars;
    }

}