package ASOserver.springapp.service;

import ASOserver.common.HashUtils;
import ASOserver.model.Account;
import ASOserver.springapp.dao.AccountDAO;

import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Account insertAccount(AccountDTO accountDTO) throws Exception {
        accountDTO.setPassword(HashUtils.generateHash(accountDTO.getPassword(), 10));
        return this.accountDAO.save(AccountMapper.toAccount(accountDTO));
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