package model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Alex on 07/03/2017.
 */
public class Account {

    private Long id;

    private String type;
    private Double amountOfMoney;
    private Date dateOfCreation;
    private String customerCNP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getCustomerCnp() {
        return customerCNP;
    }

    public void setCustomerCnp(String customerCNP) {
        this.customerCNP = customerCNP;
    }
}
