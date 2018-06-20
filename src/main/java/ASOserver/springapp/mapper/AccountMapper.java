package ASOserver.springapp.mapper;

import ASOserver.model.Account;
import ASOserver.springapp.dto.AccountDTO;

public class AccountMapper {
    public static Account toAccount(AccountDTO accountDTO){
        Account account = new Account();
        account.setAccountId(accountDTO.getId());
        account.setLogin(accountDTO.getLogin());
        account.setPassword(accountDTO.getPassword());
        account.setAccessRights(accountDTO.getAccessRights());
        return account;
    }
    public static AccountDTO toAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getAccountId());
        accountDTO.setLogin(account.getLogin());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setAccessRights(account.getAccessRights());
        return accountDTO;
    }
}