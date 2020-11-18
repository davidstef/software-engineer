package model.builder;

import model.Transaction;

public class TransactionBuilder {

    Transaction transaction;

    public TransactionBuilder() {
        this.transaction = new Transaction();
    }

    public TransactionBuilder setUsername(String username) {
        transaction.setUsername(username);
        return this;
    }

    public TransactionBuilder setPayerName(String name) {
        transaction.setPayerName(name);
        return this;
    }

    public TransactionBuilder setRecipientName(String name) {
        transaction.setRecipientName(name);
        return this;
    }

    public TransactionBuilder setIdPayerAccount(Long id) {
        transaction.setIdPayerAccount(id);
        return this;
    }

    public TransactionBuilder setAmount(Double amount) {
        transaction.setAmount(amount);
        return this;
    }

    public Transaction build() { return transaction;}





}
