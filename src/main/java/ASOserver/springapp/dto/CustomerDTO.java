package ASOserver.springapp.dto;

import java.io.Serializable;
import java.util.List;

public class CustomerDTO implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String eMail;
    private String pesel;
    private String phoneNumber;
    private AccountDTO account;
    private List<CarsDTO> cars;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", eMail='" + eMail + '\'' +
                ", pesel='" + pesel + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", account=" + account.toString() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public List<CarsDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarsDTO> cars) {
        this.cars = cars;
    }
}
