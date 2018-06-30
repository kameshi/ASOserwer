package ASOserver.springapp.dao;

import ASOserver.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends CrudRepository<Account, Long> {
    @Query("SELECT a.id FROM Account a WHERE a.login like ?1")
    long findAccountIdByLogin(@Param("login") String login);
    @Query("SELECT a FROM Account a WHERE a.login like ?1")
    Account findByUsername(@Param("login") String login);
}
