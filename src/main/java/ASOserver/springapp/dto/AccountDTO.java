package ASOserver.springapp.dto;

import ASOserver.model.Customer;
import ASOserver.model.Employee;
import java.io.Serializable;

public class AccountDTO implements Serializable {

    private Long accountId;
    private String login;
    private String password;
    private String accessRights;

    public Long getAccountId() {
        return accountId;
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

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }
}
