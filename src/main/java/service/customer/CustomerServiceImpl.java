package service.customer;

import model.Customer;
import repository.EntityNotFoundException;
import repository.customer.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findByCnp(Long cnp) throws EntityNotFoundException {
        return repository.findByCnp(cnp);
    }

    @Override
    public boolean save(Customer customer) throws EntityNotFoundException {
        return repository.save(customer);
    }

    @Override
    public boolean update(Customer customer, Long cnp) throws EntityNotFoundException {
        return repository.update(customer, cnp);
    }

    @Override
    public boolean remove(Long cnp) throws EntityNotFoundException {
        return repository.remove(cnp);
    }
}
