package repository.account;

import model.Account;
import model.Customer;
import repository.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alex on 07/03/2017.
 */
public class AccountRepositoryMock implements AccountRepository {

    private List<Account> accounts;

    public AccountRepositoryMock() {
        accounts = new ArrayList<>();
    }

    public List<Account> findAll() {
        return accounts;
    }

    public Account findById(Long id) throws EntityNotFoundException {
        List<Account> filteredAccounts = accounts.parallelStream()
                .filter(it -> it.getId().equals(id))
                .collect(Collectors.toList());
        if (filteredAccounts.size() > 0) {
            return filteredAccounts.get(0);
        }
        throw new EntityNotFoundException(id, Account.class.getSimpleName());
    }

    public boolean save(Account account) {
        return accounts.add(account);
    }

    @Override
    public boolean update(Account account, Long id) {
        List<Account> filteredAccounts = accounts.parallelStream()
                .filter(it -> it.getId().equals(id))
                .collect(Collectors.toList());
        if (filteredAccounts.size() > 0) {
            Collections.replaceAll(accounts, filteredAccounts.get(0), account);
            System.out.println(accounts.get(0).getAmountOfMoney());
            return true;
        }
        return false;


        /*for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getId().equals(id)){
                accounts.set(i, account);
                System.out.println("Miau aici");
                System.out.println(accounts.get(0).getAmountOfMoney());
                return true;
            }
        }
        return false;*/
    }

    @Override
    public boolean remove(Long id) {
        return accounts.removeIf(acc -> acc.getId().equals(id));
    }
}
