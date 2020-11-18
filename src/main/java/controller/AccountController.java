package controller;



import factory.ComponentFactory;
import model.Account;
import model.Customer;
import model.Transaction;
import model.User;
import model.builder.AccountBuilder;
import model.builder.TransactionBuilder;
import repository.EntityNotFoundException;
import repository.user.AuthenticationException;
import service.account.AccountService;
import service.customer.CustomerService;
import service.transaction.TransactionService;
import service.user.AuthenticationService;
import service.user.UserService;
import view.account.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AccountController {

    private AddAccountView addAccountView;
    private ShowAccountView showAccountView;
    private UpdateAccountView updateAccountView;
    private TransferBeweenAccountsView transferBeweenAccountsView;
    private ProcessUtilitiesView processUtilitiesView;

    private final ComponentFactory componentFactory;
    private final AccountService accountService;
    private CustomerService customerService;
    private TransactionService transactionService;
    private final AuthenticationService authenticationService;
    private String username;

    public AccountController (AddAccountView addAccountView, AuthenticationService authenticationService) {
        this.addAccountView = addAccountView;
        addAccountView.setBtnAdd(new AccountController.ButtonAddListener());
        addAccountView.setBtnBack(new AccountController.ButtonBackAddListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        accountService = componentFactory.getAccountService();
    }

    /*public AccountController (DeleteAccountView deleteAccountView, AuthenticationService authenticationService) {
        this.deleteAccountView = deleteAccountView;
        deleteAccountView.setBtnDelete(new AccountController.ButtonDeleteListener());
        deleteAccountView.setBtnBack(new AccountController.ButtonBackDeleteListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        accountService = componentFactory.getAccountService();
    }*/

    public AccountController (UpdateAccountView updateAccountView, AuthenticationService authenticationService) {
        this.updateAccountView = updateAccountView;
        updateAccountView.setBtnUpdate(new AccountController.ButtonUpdateListener());
        updateAccountView.setBtnBack(new AccountController.ButtonBackUpdateListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        accountService = componentFactory.getAccountService();
    }

    public AccountController (TransferBeweenAccountsView transferBeweenAccountsView, AuthenticationService authenticationService) {
        this.transferBeweenAccountsView = transferBeweenAccountsView;
        transferBeweenAccountsView.setBtnTransfer(new AccountController.ButtonTransferBetweenAccountsListener());
        transferBeweenAccountsView.setBtnBack(new AccountController.ButtonBackTransferBetweenAccountListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        accountService = componentFactory.getAccountService();
    }

    public AccountController (ShowAccountView showAccountView, AuthenticationService authenticationService) {
        this.showAccountView = showAccountView;
        showAccountView.setBtnView(new AccountController.ButtonViewListener());
        showAccountView.setBtnBack(new AccountController.ButtonBackViewListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        accountService = componentFactory.getAccountService();
    }

    public AccountController (ProcessUtilitiesView processUtilitiesView, String username, AuthenticationService authenticationService) {
        this.processUtilitiesView = processUtilitiesView;
        this.username = username;
        processUtilitiesView.setBtnProcess(new AccountController.ButtonProcessUtilitiesListener());
       // processUtilitiesView.setBtnBack(new AccountController.ButtonBackProcessUtilitiesListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        accountService = componentFactory.getAccountService();
        customerService = componentFactory.getCustomerService();
        transactionService = componentFactory.getTransactionService();
    }

    private class ButtonAddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                AccountBuilder accountBuilder = new AccountBuilder();
                accountBuilder.setCustomerCnp(Long.valueOf(addAccountView.getTxtCustomerCnp().getText()));
                accountBuilder.setType(addAccountView.getTxtType().getText());
                accountBuilder.setDateOfCreation(new SimpleDateFormat("DD/MM/YYYY").parse(addAccountView.getTxtDate().getText()));
                accountBuilder.setAmountOfMoney(Double.parseDouble(addAccountView.getTxtAmountOfMoney().getText()));
                Account account = accountBuilder.build();
                accountService.save(account);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(addAccountView.getContentPane(), "The account have not added!");
            }
        }
    }

    private class ButtonBackAddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addAccountView.setVisible(false);
        }
    }

    private class ButtonBackUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateAccountView.setVisible(false);
        }
    }

    /*private class ButtonBackDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteAccountView.setVisible(false);
        }
    }*/

    private class ButtonBackViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            showAccountView.setVisible(false);
        }
    }

    private class ButtonBackTransferBetweenAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            transferBeweenAccountsView.setVisible(false);
        }
    }

    private class ButtonUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AccountBuilder accountBuilder = new AccountBuilder();
            try {
                Account account = accountService.findById(Long.valueOf(updateAccountView.getTxtId().getText()));
                accountBuilder.setCustomerCnp(Long.valueOf(updateAccountView.getTxtCustomerCnp().getText()));
                accountBuilder.setType(updateAccountView.getTxtType().getText());
                accountBuilder.setAmountOfMoney(Double.parseDouble(updateAccountView.getTxtAmountOfMoney().getText()));
                accountBuilder.setDateOfCreation(new SimpleDateFormat("DD/MM/YYYY").parse(updateAccountView.getTxtDate().getText()));

                Account buildedAccount = accountBuilder.build();
                accountService.update(buildedAccount, account.getId());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(updateAccountView.getContentPane(), "The account have not updated!");
            }
        }
    }

    /*private class ButtonDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                accountService.remove(Long.valueOf(deleteAccountView.getTxtCnp().getText()));
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(deleteAccountView.getContentPane(), "The account have not deleted!");
            }
        }
    }*/

    private class ButtonViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Account account = accountService.findById(Long.valueOf(showAccountView.getTxtId().getText()));
                showAccountView.setTxtCustomerCnp("Customer CNP: " + account.getCustomerCnp());
                showAccountView.setTxtType("Type of account: " + account.getType());
                showAccountView.setTxtAmountOfMoney("Amount of money: " + account.getAmountOfMoney());
                showAccountView.setTxtDate("Date of creation: " + account.getDateOfCreation());

            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(showAccountView.getContentPane(), "The account could not be found!");
            }
        }
    }

    private class ButtonTransferBetweenAccountsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Account payerAccount = accountService.findById(Long.valueOf(transferBeweenAccountsView.getTxtIdAccount1().getText()));
                Account recipientAccount = accountService.findById(Long.valueOf(transferBeweenAccountsView.getTxtIdAccount2().getText()));
                Double amount = Double.valueOf(transferBeweenAccountsView.getTxtAmountTransferred().getText());

                /*AccountBuilder payerAccountBuilder = new AccountBuilder();
                AccountBuilder recipientAccountBuilder = new AccountBuilder();

                payerAccountBuilder.setCustomerCnp(payerAccount.getCustomerCnp());
                payerAccountBuilder.setType(payerAccount.getType());
                payerAccountBuilder.setAmountOfMoney(Double.parseDouble(updateAccountView.getTxtAmountOfMoney().getText()) - amount);
                payerAccountBuilder.setDateOfCreation(new SimpleDateFormat("DD/MM/YYYY").parse(updateAccountView.getTxtDate().getText()));
                Account buildedPayerAccount = payerAccountBuilder.build();

                recipientAccountBuilder.setCustomerCnp(recipientAccount.getCustomerCnp());
                recipientAccountBuilder.setType(recipientAccount.getType());
                recipientAccountBuilder.setAmountOfMoney(Double.parseDouble(updateAccountView.getTxtAmountOfMoney().getText()) + amount);
                recipientAccountBuilder.setDateOfCreation(new SimpleDateFormat("DD/MM/YYYY").parse(updateAccountView.getTxtDate().getText()));
                Account buildedRecipientAccount = recipientAccountBuilder.build();*/

                payerAccount.setAmountOfMoney(payerAccount.getAmountOfMoney() - amount);
                recipientAccount.setAmountOfMoney(recipientAccount.getAmountOfMoney() + amount);

                accountService.update(payerAccount, payerAccount.getId());
                accountService.update(recipientAccount, recipientAccount.getId());

            }
            catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(showAccountView.getContentPane(), "The amount could not be transferred!");
            }
        }
    }

    private class ButtonProcessUtilitiesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //User user = userService.findByUsername(processUtilitiesView.getTxtUsername().getText());

                Account payerAccount = accountService.findById(Long.valueOf(processUtilitiesView.getTxtIdAccount1().getText()));

                Double amount = Double.valueOf(processUtilitiesView.getTxtAmountTransferred().getText());

                payerAccount.setAmountOfMoney(payerAccount.getAmountOfMoney() - amount);

                TransactionBuilder transactionBuilder = new TransactionBuilder();
                System.out.println(customerService.findByCnp(payerAccount.getCustomerCnp()).getName());
                transactionBuilder.setPayerName(customerService.findByCnp(payerAccount.getCustomerCnp()).getName());
                transactionBuilder.setAmount(amount);
                transactionBuilder.setIdPayerAccount(payerAccount.getId());
                transactionBuilder.setRecipientName(processUtilitiesView.getTxtRecipientName().getText());
                transactionBuilder.setUsername(processUtilitiesView.getTxtUsername().getText());
                Transaction transaction = transactionBuilder.build();
                transactionService.save(transaction);
                accountService.update(payerAccount, payerAccount.getId());

            }
            catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(showAccountView.getContentPane(), "The amount could not be transferred!");
            }

        }
    }



}
