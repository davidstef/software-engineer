package com.code.codeevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerCategory extends AbstractEntity {

    @Size(min = 3, message = "Name must be at least 3 characters long.")
    private String name;

    @OneToMany(mappedBy = "customerCategory")
    private final List<Customer> customers = new ArrayList<>();

    public CustomerCategory(@Size(min = 3, message = "Name must be at least 3 characters long.") String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public CustomerCategory() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
