package ASOserver.model;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLE", nullable = false)
    private Boolean enable = true;

    @Column(name = "ACCESS_RIGHT", nullable = false)
    private String accessRight;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private Employee employee;

    public Account() {}

    public Long getAccountId() {
        return accountId;
    }

    public Account(String login, String password, String accessRight, Boolean enable) {
        this.login = login;
        this.password = password;
        this.accessRight = accessRight;
        this.enable = enable;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessRight() {
        return accessRight;
    }

    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}