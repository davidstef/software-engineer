package repository.account;

import model.Account;
import repository.Cache;
import repository.EntityNotFoundException;

import java.util.List;

/**
 * Created by Alex on 07/03/2017.
 */
public class AccountRepositoryCacheDecorator extends AccountRepositoryDecorator {

    private Cache<Account> cache;

    public AccountRepositoryCacheDecorator(AccountRepository accountRepository, Cache<Account> cache) {
        super(accountRepository);
        this.cache = cache;
    }

    @Override
    public List<Account> findAll() {
        if (cache.hasResult()) {
            return cache.load();
        }
        List<Account> account = decoratedRepository.findAll();
        cache.save(account);
        return account;
    }

    @Override
    public Account findById(Long id) throws EntityNotFoundException {
        return decoratedRepository.findById(id);
    }

    @Override
    public boolean save(Account account) {
        cache.invalidateCache();
        return decoratedRepository.save(account);
    }

    @Override
    public boolean update(Account account, Long id) {
        cache.invalidateCache();
        return decoratedRepository.update(account, id);
    }

    @Override
    public boolean remove(Long id) {
        cache.invalidateCache();
        return decoratedRepository.remove(id);
    }

    @Override
    public void removeAll() {
        decoratedRepository.removeAll();
    }
}
