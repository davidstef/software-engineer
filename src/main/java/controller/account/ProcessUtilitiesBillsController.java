package controller.account;

import factory.ComponentFactory;
import model.Account;
import model.Transaction;
import model.builder.TransactionBuilder;
import repository.EntityNotFoundException;
import service.account.AccountService;
import service.customer.CustomerService;
import service.transaction.TransactionService;
import view.account.ProcessUtilitiesView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessUtilitiesBillsController {

    private ProcessUtilitiesView processUtilitiesView;

    private final ComponentFactory componentFactory;
    private final AccountService accountService;
    private CustomerService customerService;
    private TransactionService transactionService;
    private String username;

    public ProcessUtilitiesBillsController (ProcessUtilitiesView processUtilitiesView, String username) {
        this.processUtilitiesView = processUtilitiesView;
        this.username = username;
        processUtilitiesView.setBtnProcess(new ProcessUtilitiesBillsController.ButtonProcessUtilitiesListener());
        processUtilitiesView.setBtnBack(new ProcessUtilitiesBillsController.ButtonBackProcessUtilitiesListener());
        componentFactory = ComponentFactory.getInstance();
        accountService = componentFactory.getAccountService();
        customerService = componentFactory.getCustomerService();
        transactionService = componentFactory.getTransactionService();
    }

    private class ButtonBackProcessUtilitiesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            processUtilitiesView.setVisible(false);
        }
    }

     private class ButtonProcessUtilitiesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Account payerAccount = accountService.findById(Long.valueOf(processUtilitiesView.getTxtIdAccount1().getText()));
                Double amount = Double.valueOf(processUtilitiesView.getTxtAmountTransferred().getText());
                payerAccount.setAmountOfMoney(payerAccount.getAmountOfMoney() - amount);

                TransactionBuilder transactionBuilder = new TransactionBuilder();
                transactionBuilder.setPayerName(customerService.findByCnp(payerAccount.getCustomerCnp()).getName());
                transactionBuilder.setAmount(amount);
                transactionBuilder.setIdPayerAccount(payerAccount.getId());
                transactionBuilder.setRecipientName(processUtilitiesView.getTxtRecipientName().getText());
                transactionBuilder.setUsername(username);
                Transaction transaction = transactionBuilder.build();
                transactionService.save(transaction);
                accountService.update(payerAccount, payerAccount.getId());
            }
             catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(processUtilitiesView.getContentPane(), "The amount could not be transferred!");
            }

        }
    }

}
