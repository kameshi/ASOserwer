package ASOserver.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAR_ID")
    private Long carId;

    @Column(name = "MAKE", nullable = false)
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
    private Date reviewDate;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CustomerCar> customerCars;

    public Car() {
    }

    public Car(String make, String model, String registrationNumber, String vin, float capacity, float power, Date reviewDate) {
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.vin = vin;
        this.capacity = capacity;
        this.power = power;
        this.reviewDate = reviewDate;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public List<CustomerCar> getCustomerCars() {
        return customerCars;
    }

    public void setCustomerCars(List<CustomerCar> customerCars) {
        this.customerCars = customerCars;
    }

}