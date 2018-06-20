package ASOserver.springapp.dto;

import java.io.Serializable;

public class CarsDTO implements Serializable{

    private Long id;
    private String make;
    private String model;
    private String registrationNumber;
    private String vin;
    private float  capacity;
    private float  power;
    private String reviewDate;
    private CustomerDTO customer;

    @Override
    public String toString() {
        return "CarsDTO{" +
                "carsId=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", vin='" + vin + '\'' +
                ", capacity=" + capacity +
                ", power=" + power +
                ", reviewDate='" + reviewDate + '\'' +
                ", customerDTO=" + customer.toString() +
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
