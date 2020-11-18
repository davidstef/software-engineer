package service.account;

import model.Account;
import model.Customer;
import repository.EntityNotFoundException;
import repository.account.AccountRepository;

import java.util.Calendar;
import java.util.Date;
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
    public boolean save(Account account) {
        return repository.save(account);
    }

    @Override
    public boolean update(Account account, Long id) {
        return repository.update(account, id);
    }

    @Override
    public boolean remove(Long id) {
        return repository.remove(id);
    }

    @Override
    public int getAccountSeniority(Long id) throws EntityNotFoundException {
        Account account = findById(id);
        Date publishedDate = account.getDateOfCreation();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(publishedDate);
        int yearOfPublishing = calendar.get(Calendar.YEAR);
        calendar.setTime(new Date());
        int yearToday = calendar.get(Calendar.YEAR);

        return yearToday - yearOfPublishing;
    }


}
