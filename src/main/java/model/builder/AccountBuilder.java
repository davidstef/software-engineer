package model.builder;

import model.Account;
import model.Customer;

import java.util.Date;

/**
 * Created by Alex on 07/03/2017.
 */
public class AccountBuilder {

    private Account account;

    public AccountBuilder() {
        account = new Account();
    }

    public AccountBuilder setType(String type) {
        account.setType(type);
        return this;
    }

    public AccountBuilder setAmountOfMoney(double amountOfMoney) {
        account.setAmountOfMoney(amountOfMoney);
        return this;
    }

    public AccountBuilder setDateOfCreation(Date dateOfCreation) {
        account.setDateOfCreation(dateOfCreation);
        return this;
    }

    public AccountBuilder setId(Long id) {
        account.setId(id);
        return this;
    }

    public AccountBuilder setCustomerCnp(Long cnp) {
        account.setCustomerCnp(cnp);
        return this;
    }

    public Account build() {
        return account;
    }
}
