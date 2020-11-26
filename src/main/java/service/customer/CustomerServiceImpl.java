package service.customer;

import model.Customer;
import service.validation.CustomerValidator;
import service.validation.Notification;
import repository.EntityNotFoundException;
import repository.customer.CustomerRepository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
    public Customer findByCnp(String cnp) throws EntityNotFoundException {
        return repository.findByCnp(cnp);
    }

    @Override
    public Notification<Boolean> save(Customer customer) throws SQLException {
        CustomerValidator customerValidator = new CustomerValidator(customer);
        boolean customerValid = customerValidator.validate();
        Notification<Boolean> customerAddNotification = new Notification<>();
        if (!customerValid) {
            customerValidator.getErrors().forEach(customerAddNotification::addError);
            customerAddNotification.setResult(Boolean.FALSE);
        } else {
            customerAddNotification.setResult(repository.save(customer));
        }
        return customerAddNotification;
    }

    @Override
    public Notification<Boolean> update(Customer customer, String cnp) throws EntityNotFoundException {
        customer.setCnp(cnp);
        CustomerValidator customerValidator = new CustomerValidator(customer);
        boolean customerValid = customerValidator.validate();
        customer.setCnp(null);
        Notification<Boolean> customerUpdateNotification = new Notification<>();
        if (!customerValid) {
            customerValidator.getErrors().forEach(customerUpdateNotification::addError);
            customerUpdateNotification.setResult(Boolean.FALSE);
        } else {
            customerUpdateNotification.setResult(repository.update(customer, cnp));
        }
        return customerUpdateNotification;
    }

    @Override
    public boolean remove(String cnp) throws EntityNotFoundException {
        Customer customer = repository.findByCnp(cnp);
        return repository.remove(cnp);
    }

}
