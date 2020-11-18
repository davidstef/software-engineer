package repository.customer;


import model.Customer;
import repository.EntityNotFoundException;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findByCnp(Long cnp) throws EntityNotFoundException;

    boolean save(Customer customer);

    boolean update(Customer customer, Long cnp);

    boolean remove(Long cnp);

}
