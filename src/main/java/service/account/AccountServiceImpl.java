package service.account;

import model.Account;
import service.validation.AccountValidator;
import service.validation.Notification;
import repository.EntityNotFoundException;
import repository.account.AccountRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Created by Alex on 07/03/2017.
 */
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Account findById(Long id) throws EntityNotFoundException {
        return repository.findById(id);
    }

    @Override
    public Notification<Boolean> save(Account account) {
        AccountValidator accountValidator = new AccountValidator(account);
        boolean accountValid = accountValidator.validate();
        Notification<Boolean> accountAddNotification = new Notification<>();
        if(!accountValid) {
            accountValidator.getErrors().forEach(accountAddNotification::addError);
            accountAddNotification.setResult(Boolean.FALSE);
        } else {
            accountAddNotification.setResult(repository.save(account));
        }
        return accountAddNotification;
    }

    @Override
    public Notification<Boolean> update(Account account, Long id) {
        account.setId(id);
        AccountValidator accountValidator = new AccountValidator(account);
        boolean accountValid = accountValidator.validate();
        Notification<Boolean> accountUpdateNotification = new Notification<>();
        if(!accountValid) {
            accountValidator.getErrors().forEach(accountUpdateNotification::addError);
            accountUpdateNotification.setResult(Boolean.FALSE);
        } else {
            accountUpdateNotification.setResult(repository.update(account, id));
        }
        return accountUpdateNotification;
    }

    @Override
    public boolean remove(Long id) {
        return repository.remove(id);
    }


}
