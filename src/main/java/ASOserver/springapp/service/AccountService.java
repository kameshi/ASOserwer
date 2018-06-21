package ASOserver.springapp.service;

import ASOserver.common.HashUtils;
import ASOserver.model.Account;
import ASOserver.springapp.dao.AccountDAO;

import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account getAccount(Long accountId) throws Exception {
        return accountDAO.findById(accountId).get();
    }

    public long getAccountId(String login) throws Exception {
        return accountDAO.findAccountIdByLogin(login);
    }

    public Account getAccountIdiCos(String login) throws Exception {
        Iterable<Account> accountIterable = this.accountDAO.findAll();
        Account account =new Account();
        for(Account tmpAccount : accountIterable) {
            if (tmpAccount.getLogin().equals(login)) {
                account.setAccessRights(tmpAccount.getAccessRights());
                account.setLogin(tmpAccount.getLogin());
                if (!tmpAccount.getAccessRights().equals("klient")) {
                    account.setAccountId(tmpAccount.getEmployee().getEmployeeId());
                    break;
                } else {
                    account.setAccountId(tmpAccount.getCustomer().getCustomerId());
                    break;
                }
            }
        }
         return account;
    }

    public List<AccountDTO> getAccountDTO() throws Exception {
        Iterable<Account> accountIterable = this.accountDAO.findAll();
        List<AccountDTO> accountDTOList = new ArrayList<>();

        for(Account tmpAccount : accountIterable){
            accountDTOList.add(AccountMapper.toAccountDTO(tmpAccount));
        }

        return accountDTOList;
    }
    public void insertAccount(AccountDTO accountDTO) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        accountDTO.setPassword(encoder.encode(accountDTO.getPassword()));
        this.accountDAO.save(AccountMapper.toAccount(accountDTO));
    }

    public void updateAccount(Long accountId, AccountDTO accountDTO) {
        accountDTO.setAccountId(accountId);
        this.accountDAO.save(AccountMapper.toAccount(accountDTO));
    }

    public void deleteAccount(Long accountId) {
        this.accountDAO.deleteById(accountId);
    }

}