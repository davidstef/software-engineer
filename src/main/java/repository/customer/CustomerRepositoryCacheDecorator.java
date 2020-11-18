package repository.customer;

import model.Customer;
import repository.Cache;
import repository.EntityNotFoundException;

import java.util.List;

public class CustomerRepositoryCacheDecorator extends CustomerRepositoryDecorator {

    private Cache<Customer> cache;

    public CustomerRepositoryCacheDecorator(CustomerRepository customerRepository, Cache<Customer> cache) {
        super(customerRepository);
        this.cache = cache;
    }

    @Override
    public List<Customer> findAll() {
        if (cache.hasResult()) {
            return cache.load();
        }
        List<Customer> customer = decoratedRepository.findAll();
        cache.save(customer);
        return customer;
    }

    @Override
    public Customer findByCnp(Long cnp) throws EntityNotFoundException {
        return decoratedRepository.findByCnp(cnp);
    }

    @Override
    public boolean save(Customer customer) {
        cache.invalidateCache();
        return decoratedRepository.save(customer);
    }

    @Override
    public boolean update(Customer customer, Long cnp) {
        cache.invalidateCache();
        return decoratedRepository.update(customer, cnp);
    }

    @Override
    public boolean remove(Long id) {
        cache.invalidateCache();
        return decoratedRepository.remove(id);
    }



}
