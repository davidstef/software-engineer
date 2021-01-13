package com.code.codeevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class CustomerDetails extends AbstractEntity {

    @NotBlank
    @Size(min = 13, max = 13, message = "CNP must be 13 characters.")
    private String cnp;

    @NotBlank(message = "Address is required.")
    private String address;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again!")
    private String email;

    public CustomerDetails(@NotBlank @Size(min = 13, max = 13, message = "CNP must be 13 characters.") String cnp, @NotBlank(message = "Address is required.") String address,
                           @NotBlank(message = "Email is required.") @Email(message = "Invalid email. Try again!") String email) {
        this.cnp = cnp;
        this.address = address;
        this.email = email;
    }

    public CustomerDetails() { }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
