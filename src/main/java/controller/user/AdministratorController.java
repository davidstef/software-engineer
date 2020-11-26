package controller.user;

import controller.LoginController;
import controller.account.AccountController;
import controller.account.ProcessUtilitiesBillsController;
import controller.account.TransferMoneyController;
import controller.customer.CustomerController;
import controller.employee.CRUDEmployeeController;
import controller.employee.GenerateReportsEmployeeController;
import factory.ComponentFactory;
import view.LoginView;
import view.account.*;
import view.customer.AddCustomerView;
import view.customer.DeleteCustomerView;
import view.customer.ShowCustomerView;
import view.customer.UpdateCustomerView;
import view.employee.*;
import view.user.AdministratorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorController {

    private final AdministratorView administratorView;
    private final String username;

    public AdministratorController(String username, AdministratorView administratorView) {
        this.administratorView = administratorView;
        this.username = username;

        administratorView.setBtnLogOut(new AdministratorController.LogOutListener());

        administratorView.setBtnAddCustomer(new AdministratorController.AddCustomerListener());
        administratorView.setBtnUpdateCustomer(new AdministratorController.UpdateCustomerListener());
        administratorView.setBtnDeleteCustomer(new AdministratorController.DeleteCustomerListener());
        administratorView.setBtnViewCustomer(new AdministratorController.ViewCustomerListener());

        administratorView.setBtnAddAccount(new AdministratorController.AddAccountListener());
        administratorView.setBtnUpdateAccount(new AdministratorController.UpdateAccountListener());
        administratorView.setBtnViewAccount(new AdministratorController.ViewAccountListener());
        administratorView.setBtnDeleteAccount(new AdministratorController.DeleteAccountListener());
        administratorView.setBtnTransferMoney(new AdministratorController.TransferBetweenAccountsListener());
        administratorView.setBtnProcessUtilities(new AdministratorController.ProcessUtilitiesListener());

        administratorView.setBtnAddEmployee(new AdministratorController.AddEmployeeListener());
        administratorView.setBtnUpdateEmployee(new AdministratorController.UpdateEmployeeListener());
        administratorView.setBtnViewEmployee(new AdministratorController.ViewEmployeeListener());
        administratorView.setBtnDeleteEmployee(new AdministratorController.DeleteEmployeeListener());

        administratorView.setBtnGenerateReports(new AdministratorController.GenerateReportsEmployeeListener());

    }

    private class AddCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddCustomerView addCustomerView = new AddCustomerView();
            CustomerController castomerController = new CustomerController(addCustomerView);
        }
    }

    private class UpdateCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateCustomerView updateCustomerView = new UpdateCustomerView();
            CustomerController customerController = new CustomerController(updateCustomerView);
        }
    }

    private class DeleteCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCustomerView deleteCustomerView = new DeleteCustomerView();
            CustomerController customerController = new CustomerController(deleteCustomerView);
        }
    }

    private class ViewCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowCustomerView showCustomerView = new ShowCustomerView();
            CustomerController customerController = new CustomerController(showCustomerView);
        }
    }

    private class AddEmployeeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddEmployeeView addEmployeeView = new AddEmployeeView();
            CRUDEmployeeController crudEmployeeController = new CRUDEmployeeController(addEmployeeView);
        }
    }

    private class UpdateEmployeeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateEmployeeView updateEmployeeView = new UpdateEmployeeView();
            CRUDEmployeeController crudEmployeeController = new CRUDEmployeeController(updateEmployeeView);
        }
    }

    private class DeleteEmployeeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteEmployeeView deleteEmployeeView = new DeleteEmployeeView();
            CRUDEmployeeController crudEmployeeController = new CRUDEmployeeController(deleteEmployeeView);
        }
    }

    private class ViewEmployeeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowEmployeeView showEmployeeView = new ShowEmployeeView();
            CRUDEmployeeController crudEmployeeController = new CRUDEmployeeController(showEmployeeView);
        }
    }

    private class AddAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddAccountView addAccountView = new AddAccountView();
            AccountController accountController = new AccountController(addAccountView);
        }
    }

    private class UpdateAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateAccountView updateAccountView = new UpdateAccountView();
            AccountController accountController = new AccountController(updateAccountView);
        }
    }

    private class ViewAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowAccountView showAccountView = new ShowAccountView();
            AccountController accountController = new AccountController(showAccountView);
        }
    }

    private class DeleteAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteAccountView deleteAccountView = new DeleteAccountView();
            AccountController accountController = new AccountController(deleteAccountView);
        }
    }

    private class TransferBetweenAccountsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TransferBeweenAccountsView transferBeweenAccountsView = new TransferBeweenAccountsView();
            TransferMoneyController transferMoneyController = new TransferMoneyController(transferBeweenAccountsView);
        }
    }

    private class ProcessUtilitiesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ProcessUtilitiesView processUtilitiesView = new ProcessUtilitiesView();
            ProcessUtilitiesBillsController processUtilitiesBillsController = new ProcessUtilitiesBillsController(processUtilitiesView, username);
        }
    }

    private class GenerateReportsEmployeeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GenerateReportsView generateReportsView = new GenerateReportsView();
            GenerateReportsEmployeeController generateReportsEmployeeController = new GenerateReportsEmployeeController(generateReportsView);
        }
    }

    private class LogOutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            administratorView.dispose();
            ComponentFactory componentFactory = ComponentFactory.getInstance();
            new LoginController(new LoginView(), componentFactory.getAuthenticationService());
        }
    }

}
