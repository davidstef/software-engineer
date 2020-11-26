package service.customer;

import model.Customer;
import model.builder.CustomerBuilder;
import org.junit.Before;
import org.junit.Test;
import repository.customer.CustomerRepositoryMock;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestCustomerServiceImpl {

    private CustomerService customerService;

    @Before
    public void setup(){
        customerService = new CustomerServiceImpl(new CustomerRepositoryMock());
    }


    @Test
    public void findAll() throws Exception {
        assertEquals(0, customerService.findAll().size());
    }

    @Test
    public void save() throws Exception {
        assertTrue(customerService.save(new Customer()).hasErrors() == true);
    }

    @Test
    public void update() throws Exception {
        customerService.save(
                new CustomerBuilder()
                        .setCnp("1970923948255")
                        .setAdress("Strada Alunelor")
                        .setIcn(2314L)
                        .setEmail("dorin@gmail.com")
                        .setPhoneNumber("0756234516")
                        .setName("Animal Dorin")
                        .build()
        );
        assertTrue(customerService.update(
                new CustomerBuilder()
                        .setCnp("1970923948255")
                        .setAdress("Strada Alunelor")
                        .setIcn(2314L)
                        .setEmail("dorin@gmail.com")
                        .setPhoneNumber("0756234516")
                        .setName("Animal Dorin")
                        .build()
                , "1970923948233").getResult());
    }

    @Test
    public void delete() throws Exception {
        customerService.save(
                new CustomerBuilder()
                        .setCnp("1970923948255")
                        .setAdress("Strada Alunelor")
                        .setIcn(2314L)
                        .setEmail("dorin@gmail.com")
                        .setPhoneNumber("0756234516")
                        .setName("Animal Dorin")
                        .build()
        );
        customerService.remove("1970923948255");
        assertTrue(customerService.findAll().isEmpty());
    }

}
