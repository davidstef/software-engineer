package repository.customer;

import model.Account;
import model.Customer;
import repository.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepositoryMock implements CustomerRepository {

    private List<Customer> customers;

    public CustomerRepositoryMock() {
        customers = new ArrayList<>();
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Customer findByCnp(Long cnp) throws EntityNotFoundException {
        List<Customer> filteredCustomers = customers.parallelStream()
                .filter(it -> it.getCnp().equals(cnp))
                .collect(Collectors.toList());
        if (filteredCustomers.size() > 0) {
            return filteredCustomers.get(0);
        }
        throw new EntityNotFoundException(cnp, Customer.class.getSimpleName());
    }

    public boolean save(Customer customer) {
        return customers.add(customer);
    }

    @Override
    public boolean update(Customer customer, Long cnp) {
        List<Customer> filteredCustomers = customers.parallelStream()
                .filter(it -> it.getCnp().equals(cnp))
                .collect(Collectors.toList());
        if (filteredCustomers.size() > 0) {
            Collections.replaceAll(customers, filteredCustomers.get(0), customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Long cnp) {
        return customers.removeIf(customer -> customer.getCnp().equals(cnp));
    }


}
