package model;

public class Transaction {

    private String username;
    private String payerName;
    private Long idPayerAccount;
    private String recipientName;
    private Double amount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Long getIdPayerAccount() {
        return idPayerAccount;
    }

    public void setIdPayerAccount(Long idPayerAccount) {
        this.idPayerAccount = idPayerAccount;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
