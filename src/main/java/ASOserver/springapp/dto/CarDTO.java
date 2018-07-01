package ASOserver.springapp.dto;

import java.io.Serializable;
import java.sql.Date;

public class CarDTO implements Serializable{

    private Long id;
    private String make;
    private String model;
    private String registrationNumber;
    private String vin;
    private float engineSize;
    private float enginePower;
    private Date reviewDate;
    private CustomerDTO customer;

    @Override
    public String toString() {
        return "CarDTO{" +
                "carsId=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", vin='" + vin + '\'' +
                ", capacity=" + engineSize +
                ", power=" + enginePower +
                ", reviewDate='" + reviewDate + '\'' +
                //", customerDTO=" + customer.toString() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(float engineSize) {
        this.engineSize = engineSize;
    }

    public float getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(float enginePower) {
        this.enginePower = enginePower;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
