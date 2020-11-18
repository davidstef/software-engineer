package model.builder;

import model.Customer;

import java.util.Date;

/**
 * Created by Alex on 07/03/2017.
 */
public class CustomerBuilder {

    private Customer customer;

    public CustomerBuilder() {
        customer = new Customer();
    }

    public CustomerBuilder setCnp(Long cnp) {
        customer.setCnp(cnp);
        return this;
    }

    public CustomerBuilder setName(String name) {
        customer.setName(name);
        return this;
    }

    public CustomerBuilder setIcn(Long icn) {
        customer.setIcn(icn);
        return this;
    }

    public CustomerBuilder setAdress(String adress) {
        customer.setAdress(adress);
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        customer.setEmail(email);
        return this;
    }

    public CustomerBuilder setPhoneNumber(Long phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
        return this;
    }

    public Customer build() {
        return customer;
    }
}

