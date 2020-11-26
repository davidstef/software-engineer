package service.account;

import model.Account;
import service.validation.Notification;
import repository.EntityNotFoundException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Created by Alex on 07/03/2017.
 */
public interface AccountService {

    List<Account> findAll();

    Account findById(Long id) throws EntityNotFoundException;

    Notification<Boolean> save(Account account) throws EntityNotFoundException;

    Notification<Boolean> update(Account account, Long id) throws EntityNotFoundException;

    boolean remove(Long id) throws EntityNotFoundException;

}
