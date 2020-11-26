package repository.customer;

import database.DBConnectionFactory;
import model.Customer;
import model.builder.CustomerBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.Cache;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCustomerRepositoryMySQL {

    private static CustomerRepository customerRepository;

    @BeforeClass
    public static void setupClass() {
        customerRepository = new CustomerRepositoryCacheDecorator(
                new CustomerRepositoryMySQL(
                        new DBConnectionFactory().getConnectionWrapper(true).getConnection()
                ),
                new Cache<>()
        );
    }

    @Before
    public void cleanUp() {
        customerRepository.removeAll();
    }


    @Test
    public void findAll() throws Exception {
        List<Customer> customers = customerRepository.findAll();
        assertEquals(customers.size(), 0);
    }

    @Test
    public void findAllWhenDbNotEmpty() throws Exception {
        Customer customer = new CustomerBuilder()
                .setCnp("1970923948233")
                .setAdress("Strada Alunelor")
                .setIcn(2314L)
                .setEmail("dorin@gmail.com")
                .setPhoneNumber("0756234516")
                .setName("Animal Dorin")
                .build();
        customerRepository.save(customer);
        customer.setCnp("1970923948244");
        customerRepository.save(customer);
        customer.setCnp("1970923948255");
        customerRepository.save(customer);

        List<Customer> customers = customerRepository.findAll();
        assertEquals(customers.size(), 3);
    }

    @Test
    public void update() throws Exception {
        Customer customer = new CustomerBuilder()
                .setCnp("1970923948233")
                .setAdress("Strada Alunelor")
                .setIcn(2314L)
                .setEmail("dorin@gmail.com")
                .setPhoneNumber("0756234516")
                .setName("Animal Dorin")
                .build();
        customerRepository.save(customer);
        customer.setCnp("1970923948244");
        customerRepository.save(customer);
        customer.setCnp("1970923948255");
        customerRepository.save(customer);
        assertTrue(customerRepository.update(
                new CustomerBuilder()
                        .setCnp("1970923948255")
                        .setAdress("Strada Alunelor")
                        .setIcn(2314L)
                        .setEmail("dorin@gmail.com")
                        .setPhoneNumber("0756234516")
                        .setName("Animal Dorin")
                        .build()
        , "1970923948233"));
    }

    @Test
    public void save() throws Exception {
        assertTrue(customerRepository.save(
                new CustomerBuilder()
                        .setCnp("1970923948255")
                        .setAdress("Strada Alunelor")
                        .setIcn(2314L)
                        .setEmail("dorin@gmail.com")
                        .setPhoneNumber("0756234516")
                        .setName("Animal Dorin")
                        .build()
        ));
    }

    @Test
    public void findByCNP() throws Exception {
        Customer customer = new CustomerBuilder()
                .setCnp("1970923948233")
                .setAdress("Strada Alunelor")
                .setIcn(2314L)
                .setEmail("dorin@gmail.com")
                .setPhoneNumber("0756234516")
                .setName("Animal Dorin")
                .build();
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findByCnp("1970923948233");
        assertTrue(customer1 != null);
    }

    @Test
    public void remove() throws Exception {
        Customer customer = new CustomerBuilder()
                .setCnp("1970923948233")
                .setAdress("Strada Alunelor")
                .setIcn(2314L)
                .setEmail("dorin@gmail.com")
                .setPhoneNumber("0756234516")
                .setName("Animal Dorin")
                .build();
        customerRepository.save(customer);
        customerRepository.remove("1970923948233");
        assertTrue(customerRepository.findAll().isEmpty());
    }
}
