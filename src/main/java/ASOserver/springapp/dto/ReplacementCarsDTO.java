package ASOserver.springapp.dto;

import java.io.Serializable;

/**
 * Created by user on 2018-06-14.
 */
public class ReplacementCarsDTO implements Serializable {
    private Long replacementCarsId;
    private String model;
    private String make;
    private String registrationNumber;
    private String vin;

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
