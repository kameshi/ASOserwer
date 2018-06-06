package ASOserver.springapp.dto;

import ASOserver.model.Account;
import sun.misc.Queue;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private Long customerId;
    private String name;
    private String surname;
    private String pesel;
    private String eMail;
    private String phoneNumber;
    private Account account;
    private Queue<CustomerReplacementVehicleDTO> CustomerReplacementVehicle;
    private Queue<CustomerVehicleDTO> CustomerVehicle;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Queue<CustomerReplacementVehicleDTO> getCustomerReplacementVehicle() {
        return CustomerReplacementVehicle;
    }

    public void setCustomerReplacementVehicle(Queue<CustomerReplacementVehicleDTO> customerReplacementVehicle) {
        CustomerReplacementVehicle = customerReplacementVehicle;
    }

    public Queue<CustomerVehicleDTO> getCustomerVehicle() {
        return CustomerVehicle;
    }

    public void setCustomerVehicle(Queue<CustomerVehicleDTO> customerVehicle) {
        CustomerVehicle = customerVehicle;
    }
}
