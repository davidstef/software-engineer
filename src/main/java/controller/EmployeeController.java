package controller;

import model.Account;
import service.user.AuthenticationService;
import view.EmployeeView;
import view.account.*;
import view.customer.AddCustomerView;
import view.customer.DeleteCustomerView;
import view.customer.ShowCustomerView;
import view.customer.UpdateCustomerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {

    private AuthenticationService authenticationService;
    private EmployeeView employeeView;
    private String username;

    public EmployeeController(AuthenticationService authenticationService, String username, EmployeeView employeeView) {
        this.authenticationService = authenticationService;
        this.employeeView = employeeView;
        this.username = username;
        employeeView.setBtnLogOut(new EmployeeController.LogOutListener());
        employeeView.setBtnAddCustomer(new EmployeeController.AddCustomerListener());
        employeeView.setBtnUpdateCustomer(new EmployeeController.UpdateCustomerListener());
        employeeView.setBtnDeleteCustomer(new EmployeeController.DeleteCustomerListener());
        employeeView.setBtnViewCustomer(new EmployeeController.ViewCustomerListener());

        employeeView.setBtnAddAccount(new EmployeeController.AddAccountListener());
        employeeView.setBtnUpdateAccount(new EmployeeController.UpdateAccountListener());
        employeeView.setBtnViewAccount(new EmployeeController.ViewAccountListener());
        employeeView.setBtnTransferMoney(new EmployeeController.TransferBetweenAccountsListener());

        employeeView.setBtnProcessUtilities(new EmployeeController.ProcessUtilitiesListener());

    }

    private class AddCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddCustomerView addCustomerView = new AddCustomerView();
            CustomerController castomerController = new CustomerController(addCustomerView, authenticationService);
        }
    }

    private class UpdateCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateCustomerView updateCustomerView = new UpdateCustomerView();
            CustomerController customerController = new CustomerController(updateCustomerView, authenticationService);
        }
    }

    private class DeleteCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCustomerView deleteCustomerView = new DeleteCustomerView();
            CustomerController customerController = new CustomerController(deleteCustomerView, authenticationService);
        }
    }

    private class ViewCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowCustomerView showCustomerView = new ShowCustomerView();
            CustomerController customerController = new CustomerController(showCustomerView, authenticationService);
        }
    }

    private class AddAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddAccountView addAccountView = new AddAccountView();
            AccountController accountController = new AccountController(addAccountView, authenticationService);
        }
    }

    private class UpdateAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateAccountView updateAccountView = new UpdateAccountView();
            AccountController accountController = new AccountController(updateAccountView, authenticationService);
        }
    }

    private class ViewAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowAccountView showAccountView = new ShowAccountView();
            AccountController accountController = new AccountController(showAccountView, authenticationService);
        }
    }

    private class TransferBetweenAccountsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TransferBeweenAccountsView transferBeweenAccountsView = new TransferBeweenAccountsView();
            AccountController accountController = new AccountController(transferBeweenAccountsView, authenticationService);
        }
    }

    private class ProcessUtilitiesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ProcessUtilitiesView processUtilitiesView = new ProcessUtilitiesView();
            AccountController accountController = new AccountController(processUtilitiesView, username, authenticationService);
        }
    }

    private class LogOutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.setVisible(false);
        }
    }




}
