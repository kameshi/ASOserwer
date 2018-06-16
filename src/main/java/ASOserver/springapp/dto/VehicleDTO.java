package ASOserver.springapp.dto;

import java.io.Serializable;

/**
 * Created by user on 2018-06-14.
 */
public class VehicleDTO implements Serializable{

    private Long vehicleId;
    private String mark;
    private String model;
    private String registrationNumber;
    private String vin;
    private float  capacity;
    private float  power;
    private String reviewDate;
    private CustomerDTO customerDTO;

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "vehicleId=" + vehicleId +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", vin='" + vin + '\'' +
                ", capacity=" + capacity +
                ", power=" + power +
                ", reviewDate='" + reviewDate + '\'' +
                ", customerDTO=" + customerDTO.toString() +
                '}';
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

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
}