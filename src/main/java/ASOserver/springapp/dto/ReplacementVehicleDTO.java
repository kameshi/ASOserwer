package ASOserver.springapp.dto;

import sun.misc.Queue;
import java.io.Serializable;

public class ReplacementVehicleDTO implements Serializable {

    private Long replacementVehicleId;
    private String model;
    private String mark;
    private String registrationNumber;
    private String vin;
    private Queue<CustomerReplacementVehicleDTO> customerReplacementVehicle;

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

    public Queue<CustomerReplacementVehicleDTO> getCustomerReplacementVehicle() {
        return customerReplacementVehicle;
    }

    public void setCustomerReplacementVehicle(Queue<CustomerReplacementVehicleDTO> customerReplacementVehicle) {
        this.customerReplacementVehicle = customerReplacementVehicle;
    }
}
