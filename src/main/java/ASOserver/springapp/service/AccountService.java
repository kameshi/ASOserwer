package ASOserver.springapp.service;

import ASOserver.common.HashUtils;
import ASOserver.model.Account;
import ASOserver.model.enums.AccessRight;
import ASOserver.springapp.dao.AccountDAO;

import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Account insertAccount(AccountDTO accountDTO) throws Exception {
        accountDTO.setPassword(HashUtils.generateHash(accountDTO.getPassword(), 10));
        return this.accountDAO.save(AccountMapper.toAccount(accountDTO));
    }

    public Account getAccountIdiCos(String login) throws Exception {
        Iterable<Account> accountIterable = this.accountDAO.findAll();
        Account account =new Account();
        for(Account tmpAccount : accountIterable) {
            if (tmpAccount.getLogin().equals(login)) {
                account.setAccessRight(tmpAccount.getAccessRight());
                account.setLogin(tmpAccount.getLogin());
                if (!tmpAccount.getAccessRight().equals(AccessRight.AccessRightEnum.CUSTOMER.getAccessRight())) {
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

    public Account updateAccount(Long accountId, AccountDTO accountDTO) throws Exception {
        accountDTO.setId(accountId);
        accountDTO.setPassword(HashUtils.generateHash(accountDTO.getPassword(), 10));
        return this.accountDAO.save(AccountMapper.toAccount(accountDTO));
    }

    public void deleteAccount(Long accountId) {
        this.accountDAO.deleteById(accountId);
    }

}