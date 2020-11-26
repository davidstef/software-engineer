package repository.customer;


import model.Customer;
import repository.EntityNotFoundException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findByCnp(String cnp) throws EntityNotFoundException;

    boolean save(Customer customer) throws SQLException, SQLIntegrityConstraintViolationException;

    boolean update(Customer customer, String cnp);

    boolean remove(String cnp);

    void removeAll();

}
