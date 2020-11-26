package repository.account;

import model.Account;
import repository.EntityNotFoundException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Created by Alex on 07/03/2017.
 */
public interface AccountRepository {

    List<Account> findAll();

    Account findById(Long id) throws EntityNotFoundException;

    boolean save(Account account);

    boolean update(Account account, Long id);

    boolean remove(Long id);

    void removeAll();

}
