package service.customer;

import model.Customer;
import repository.EntityNotFoundException;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findByCnp(Long cnp) throws EntityNotFoundException;

    boolean save(Customer customer) throws EntityNotFoundException;

    boolean update(Customer customer, Long cnp) throws EntityNotFoundException;

    boolean remove(Long cnp) throws EntityNotFoundException;
}
