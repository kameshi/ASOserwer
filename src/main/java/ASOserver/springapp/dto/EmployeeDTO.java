package ASOserver.springapp.dto;

import ASOserver.model.Account;
import sun.misc.Queue;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{

    private Long employeeId;
    private String name;
    private String surname;
    private String eMail;
    private String pesel;
    private String phoneNumber;
    private Account account;
    private Queue<SpecificServiceDTO> specificService;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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

    public Queue<SpecificServiceDTO> getSpecificService() {
        return specificService;
    }

    public void setSpecificService(Queue<SpecificServiceDTO> specificService) {
        this.specificService = specificService;
    }
}
