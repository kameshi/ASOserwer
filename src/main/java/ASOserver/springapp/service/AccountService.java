package ASOserver.springapp.service;

import ASOserver.model.Account;
import ASOserver.springapp.dao.AccountDAO;
import ASOserver.springapp.dto.AccountDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public List<AccountDTO> getAccount() throws Exception{
        ModelMapper modelMapper = new ModelMapper();
        Iterable<Account> accountIterable = this.accountDAO.findAll();
        List<AccountDTO> accountDTOList = new ArrayList<>();

        for (Account account : accountIterable){
            accountDTOList.add(modelMapper.map(account, AccountDTO.class));
        }
        return accountDTOList;
    }

}
