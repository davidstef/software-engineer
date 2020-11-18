package model;

import java.util.Date;

/**
 * Created by Alex on 07/03/2017.
 */
public class Customer {

    private Long CNP;

    private String name;
    private Long ICN;
    private String adress;
    private Long phoneNumber;
    private String email;

    public Long getCnp() {
        return CNP;
    }

    public void setCnp(Long CNP) {
        this.CNP = CNP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIcn() {
        return ICN;
    }

    public void setIcn(Long Icn) {
        this.ICN = Icn;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
