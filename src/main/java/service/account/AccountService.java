package service.account;

import model.Account;
import model.Customer;
import repository.EntityNotFoundException;

import java.util.List;

/**
 * Created by Alex on 07/03/2017.
 */
public interface AccountService {

    List<Account> findAll();

    Account findById(Long id) throws EntityNotFoundException;

    boolean save(Account account) throws EntityNotFoundException;

    boolean update(Account account, Long id) throws EntityNotFoundException;

    boolean remove(Long id) throws EntityNotFoundException;

    int getAccountSeniority(Long id) throws EntityNotFoundException;

}
