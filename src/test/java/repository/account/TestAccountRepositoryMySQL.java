package repository.account;

import database.DBConnectionFactory;
import model.Account;
import model.Customer;
import model.builder.AccountBuilder;
import model.builder.CustomerBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.Cache;
import repository.customer.CustomerRepository;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAccountRepositoryMySQL {

        private static AccountRepository accountRepository;
        private static CustomerRepository customerRepository;

        @BeforeClass
        public static void setupClass() {
            accountRepository = new AccountRepositoryCacheDecorator(
                    new AccountRepositoryMySQL(
                        new DBConnectionFactory().getConnectionWrapper(true).getConnection()
                    ),
                    new Cache<>()
            );
        }

        @Before
        public void cleanUp() {
            accountRepository.removeAll();
        }

        @Test
        public void findAll() throws Exception {
            List<Account> accounts = accountRepository.findAll();
            assertEquals(accounts.size(), 0);
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
            Account account = new AccountBuilder()
                    .setId(1L)
                    .setCustomerCnp("1990872111928")
                    .setAmountOfMoney(1700.50)
                    .setType("SAVINGS")
                    .setDateOfCreation(new Date())
                    .build();
            accountRepository.save(account);
            accountRepository.save(account);

            List<Account> accounts = accountRepository.findAll();
            assertEquals(accounts.size(), 2);
        }

        @Test
        public void findById() throws Exception {
            Customer customer = new CustomerBuilder()
                    .setCnp("1970923948233")
                    .setAdress("Strada Alunelor")
                    .setIcn(2314L)
                    .setEmail("dorin@gmail.com")
                    .setPhoneNumber("0756234516")
                    .setName("Animal Dorin")
                    .build();
            customerRepository.save(customer);
            Account account = new AccountBuilder()
                    .setId(1L)
                    .setCustomerCnp("1990872111928")
                    .setAmountOfMoney(1700.50)
                    .setType("SAVINGS")
                    .setDateOfCreation(new Date())
                    .build();
            accountRepository.save(account);
            accountRepository.save(account);
            accountRepository.save(account);
            assertTrue(accountRepository.findById(2L) != null);

        }

        @Test
        public void save() throws Exception {
            Customer customer = new CustomerBuilder()
                    .setCnp("1970923948233")
                    .setAdress("Strada Alunelor")
                    .setIcn(2314L)
                    .setEmail("dorin@gmail.com")
                    .setPhoneNumber("0756234516")
                    .setName("Animal Dorin")
                    .build();
            customerRepository.save(customer);
            assertTrue(accountRepository.save(
                    new AccountBuilder()
                            .setId(1L)
                            .setCustomerCnp("1990872111928")
                            .setAmountOfMoney(1700.50)
                            .setType("SAVINGS")
                            .setDateOfCreation(new Date())
                            .build()
            ));
        }

        @Test
        public void removeAll() throws Exception {
            Customer customer = new CustomerBuilder()
                    .setCnp("1970923948233")
                    .setAdress("Strada Alunelor")
                    .setIcn(2314L)
                    .setEmail("dorin@gmail.com")
                    .setPhoneNumber("0756234516")
                    .setName("Animal Dorin")
                    .build();
            customerRepository.save(customer);
            assertTrue(accountRepository.save(
                    new AccountBuilder()
                            .setId(1L)
                            .setCustomerCnp("1990872111928")
                            .setAmountOfMoney(1700.50)
                            .setType("SAVINGS")
                            .setDateOfCreation(new Date())
                            .build()
            ));
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
            assertTrue(accountRepository.save(
                    new AccountBuilder()
                            .setId(1L)
                            .setCustomerCnp("1990872111928")
                            .setAmountOfMoney(1700.50)
                            .setType("SAVINGS")
                            .setDateOfCreation(new Date())
                            .build()
            ));
            assertTrue(accountRepository.update(
                    new AccountBuilder()
                            .setId(1L)
                            .setCustomerCnp("1990872111928")
                            .setAmountOfMoney(1700.50)
                            .setType("SAVINGS")
                            .setDateOfCreation(new Date())
                            .build()
            , 1L));
        }


        @Test
        public void delete() throws Exception {

            assertTrue(accountRepository.save(
                    new AccountBuilder()
                            .setId(2L)
                            .setCustomerCnp("1990872111928")
                            .setAmountOfMoney(1700.50)
                            .setType("SAVINGS")
                            .setDateOfCreation(new Date())
                            .build()
            ));
            accountRepository.remove(2L);
            assertTrue(accountRepository.findAll().size() == 0);
        }

}
