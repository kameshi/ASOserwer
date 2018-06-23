package ASOserver.springapp.dto;

import ASOserver.model.enums.AccessRight;

import java.io.Serializable;

public class AccountDTO implements Serializable {

    private Long id;
    private String login;
    private String password;
    private AccessRight.AccessRightEnum accessRight;

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", accessRight='" + accessRight + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAccountId(Long accountId) {
        this.id = accountId;
    }
}
