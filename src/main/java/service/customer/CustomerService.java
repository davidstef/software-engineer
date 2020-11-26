package service.customer;

import model.Customer;
import service.validation.Notification;
import repository.EntityNotFoundException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findByCnp(String cnp) throws EntityNotFoundException;

    Notification<Boolean> save(Customer customer) throws SQLException;

    Notification<Boolean> update(Customer customer, String cnp) throws EntityNotFoundException;

    boolean remove(String cnp) throws EntityNotFoundException;
}
