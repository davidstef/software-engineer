package service.account;

import model.builder.AccountBuilder;
import org.junit.Before;
import org.junit.Test;
import repository.EntityNotFoundException;
import repository.account.AccountRepositoryMock;
import service.validation.Notification;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAccountServiceImpl {

    private AccountService accountService;

    @Before
    public void setup(){
        accountService = new AccountServiceImpl(new AccountRepositoryMock());
    }

    @Test
    public void findAll() throws Exception {
        assertEquals(0, accountService.findAll().size());
    }

    @Test(expected = EntityNotFoundException.class)
    public void findByIdEx() throws Exception {
        accountService.findById(1L);
    }

    @Test
    public void save() throws Exception {
        assertTrue(accountService.save(
                new AccountBuilder()
                        .setId(1L)
                        .setCustomerCnp("1990872111928")
                        .setAmountOfMoney(1700.50)
                        .setType("SAVINGS")
                        .setDateOfCreation(new Date())
                        .build()).getResult()
        );
    }

    @Test
    public void update() throws Exception {
        accountService.save(
                new AccountBuilder()
                        .setId(1L)
                        .setCustomerCnp("1990872111928")
                        .setAmountOfMoney(1700.50)
                        .setType("SAVINGS")
                        .setDateOfCreation(new Date())
                        .build());
        assertTrue(accountService.save(
                new AccountBuilder()
                        .setId(1L)
                        .setCustomerCnp("1990872111928")
                        .setAmountOfMoney(1700.50)
                        .setType("SAVINGS")
                        .setDateOfCreation(new Date())
                        .build()).getResult()
        );
    }

    @Test
    public void delete() throws Exception {

        accountService.save(
                new AccountBuilder()
                        .setId(1L)
                        .setCustomerCnp("1990872111928")
                        .setAmountOfMoney(1700.50)
                        .setType("SAVINGS")
                        .setDateOfCreation(new Date())
                        .build());
        accountService.remove(1L);
        assertTrue(accountService.findAll().isEmpty());
    }


}
