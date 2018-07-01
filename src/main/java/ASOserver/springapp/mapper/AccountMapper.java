package ASOserver.springapp.mapper;

import ASOserver.model.Account;
import ASOserver.model.enums.AccessRight;
import ASOserver.springapp.dto.AccountDTO;

public class AccountMapper {

    public static Account toAccount(AccountDTO accountDTO){
        Account account = new Account();
        account.setAccountId(accountDTO.getId());
        account.setLogin(accountDTO.getLogin());
        account.setPassword(accountDTO.getPassword());
        account.setAccessRight(accountDTO.getAccessRight().getAccessRight());
        return account;
    }

    public static AccountDTO toAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getAccountId());
        accountDTO.setLogin(account.getLogin());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setAccessRight(AccessRight.AccessRightEnum.getAccessRight(account.getAccessRight()));
        return accountDTO;
    }
}