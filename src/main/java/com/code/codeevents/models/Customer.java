package com.code.codeevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer extends AbstractEntity {

    @NotBlank(message = "First Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String firstName;

    @NotBlank(message = "Last Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private CustomerDetails customerDetails;

    @ManyToOne
    @NotNull(message = "Category is required.")
    private CustomerCategory customerCategory;

    public Customer(String firstName, String lastName, CustomerCategory customerCategory) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerCategory = customerCategory;
    }

    public Customer() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public CustomerCategory getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
