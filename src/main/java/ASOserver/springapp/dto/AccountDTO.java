package ASOserver.springapp.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable {

    private Long id;
    private String login;
    private String password;
    private String accessRights;

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", accessRights='" + accessRights + '\'' +
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

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }
}
