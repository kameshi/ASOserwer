package ASOserver.model;

import ASOserver.model.enums.AccessRight;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCESS_RIGHT", nullable = false)
    private AccessRight.AccessRightEnum accessRight;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private Employee employee;

    public Account() {}

    public Long getAccountId() {
        return accountId;
    }

    public Account(String login, String password, AccessRight.AccessRightEnum accessRight) {
        this.login = login;
        this.password = password;
        this.accessRight = accessRight;
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

    public AccessRight.AccessRightEnum getAccessRight() {
        return accessRight;
    }

    public void setAccessRight(AccessRight.AccessRightEnum accessRight) {
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
}