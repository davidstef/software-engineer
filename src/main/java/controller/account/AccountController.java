package controller.account;

import factory.ComponentFactory;
import model.Account;
import model.Customer;
import model.Transaction;
import model.builder.AccountBuilder;
import model.builder.TransactionBuilder;
import service.validation.Notification;
import repository.EntityNotFoundException;
import service.account.AccountService;
import service.customer.CustomerService;
import service.transaction.TransactionService;
import view.account.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;

public class AccountController {

    private AddAccountView addAccountView;
    private ShowAccountView showAccountView;
    private UpdateAccountView updateAccountView;
    private DeleteAccountView deleteAccountView;

    private final ComponentFactory componentFactory;
    private final AccountService accountService;
    private CustomerService customerService;

    public AccountController (AddAccountView addAccountView) {
        this.addAccountView = addAccountView;
        addAccountView.setBtnAdd(new AccountController.ButtonAddListener());
        addAccountView.setBtnBack(new AccountController.ButtonBackAddListener());
        componentFactory = ComponentFactory.getInstance();
        accountService = componentFactory.getAccountService();
        customerService = componentFactory.getCustomerService();
    }

    public AccountController (DeleteAccountView deleteAccountView) {
        this.deleteAccountView = deleteAccountView;
        deleteAccountView.setBtnDelete(new AccountController.ButtonDeleteListener());
        deleteAccountView.setBtnBack(new AccountController.ButtonBackDeleteListener());
        componentFactory = ComponentFactory.getInstance();
        accountService = componentFactory.getAccountService();
    }

    public AccountController (UpdateAccountView updateAccountView) {
        this.updateAccountView = updateAccountView;
        updateAccountView.setBtnUpdate(new AccountController.ButtonUpdateListener());
        updateAccountView.setBtnBack(new AccountController.ButtonBackUpdateListener());
        componentFactory = ComponentFactory.getInstance();
        accountService = componentFactory.getAccountService();
        customerService = componentFactory.getCustomerService();
    }

    public AccountController (ShowAccountView showAccountView) {
        this.showAccountView = showAccountView;
        showAccountView.setBtnView(new AccountController.ButtonViewListener());
        showAccountView.setBtnBack(new AccountController.ButtonBackViewListener());
        componentFactory = ComponentFactory.getInstance();
        accountService = componentFactory.getAccountService();
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

    private class ButtonBackDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteAccountView.setVisible(false);
        }
    }

    private class ButtonBackViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            showAccountView.setVisible(false);
        }
    }

    private class ButtonAddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            long millis=System.currentTimeMillis();
            Customer customer = null;
            try {
                customer = customerService.findByCnp(addAccountView.getTxtCustomerCnp().getText());
            } catch (EntityNotFoundException exc) {
                    JOptionPane.showMessageDialog(addAccountView.getContentPane(), "You can't add an account because the customer with this cnp doesn't exists");
            }
            try {
                AccountBuilder accountBuilder = new AccountBuilder();
                accountBuilder.setCustomerCnp(addAccountView.getTxtCustomerCnp().getText());
                accountBuilder.setType(addAccountView.getTxtType().getText());
                accountBuilder.setDateOfCreation(new java.util.Date(millis));
                accountBuilder.setAmountOfMoney(Double.parseDouble(addAccountView.getTxtAmountOfMoney().getText()));
                Account account = accountBuilder.build();
                Notification<Boolean> accountAddNotification;
                accountAddNotification = accountService.save(account);
                if(accountAddNotification.hasErrors()) {
                    JOptionPane.showMessageDialog(addAccountView.getContentPane(), accountAddNotification.getFormattedErrors());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addAccountView.getContentPane(), "Incorrect input: amount of money!");
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(addAccountView.getContentPane(), "The account have not added!");
            }
        }
    }

    private class ButtonUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AccountBuilder accountBuilder = new AccountBuilder();
            long millis=System.currentTimeMillis();
            try {
                accountBuilder.setCustomerCnp(updateAccountView.getTxtCustomerCnp().getText());
                accountBuilder.setType(updateAccountView.getTxtType().getText());
                accountBuilder.setAmountOfMoney(Double.parseDouble(updateAccountView.getTxtAmountOfMoney().getText()));
                accountBuilder.setDateOfCreation(new java.util.Date(millis));
                Account buildedAccount = accountBuilder.build();
                Notification<Boolean> accountUpdateNotification;

                Account account = accountService.findById(Long.valueOf(updateAccountView.getTxtId().getText()));
                accountUpdateNotification = accountService.update(buildedAccount, account.getId());
                if (accountUpdateNotification.hasErrors()) {
                    JOptionPane.showMessageDialog(updateAccountView.getContentPane(), accountUpdateNotification.getFormattedErrors());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(updateAccountView.getContentPane(), "Incorrect input: amount of money!");
            }  catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(updateAccountView.getContentPane(), "The account id doesn't exists!");
            }
        }
    }

    private class ButtonDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                accountService.remove(Long.valueOf(deleteAccountView.getTxtId().getText()));
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(deleteAccountView.getContentPane(), "The account have not deleted!");
            }
        }
    }

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

}
