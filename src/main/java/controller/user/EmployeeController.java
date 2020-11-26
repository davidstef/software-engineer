package controller.user;

import controller.LoginController;
import controller.account.AccountController;
import controller.account.ProcessUtilitiesBillsController;
import controller.account.TransferMoneyController;
import controller.customer.CustomerController;
import factory.ComponentFactory;
import repository.EntityNotFoundException;
import service.customer.CustomerService;
import service.report.ReportService;
import service.user.AuthenticationService;
import view.user.EmployeeView;
import view.LoginView;
import view.account.*;
import view.customer.AddCustomerView;
import view.customer.DeleteCustomerView;
import view.customer.ShowCustomerView;
import view.customer.UpdateCustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {

    private final EmployeeView employeeView;
    private final String username;
    private final CustomerService customerService;
    private final ComponentFactory componentFactory;
    private final ReportService  reportService;

    public EmployeeController(String username, EmployeeView employeeView) {
        componentFactory = ComponentFactory.getInstance();
        customerService = componentFactory.getCustomerService();
        reportService = componentFactory.getReportService();
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
        employeeView.setBtnDeleteAccount(new EmployeeController.DeleteAccountListener());
        employeeView.setBtnTransferMoney(new EmployeeController.TransferBetweenAccountsListener());
        employeeView.setBtnProcessUtilities(new EmployeeController.ProcessUtilitiesListener());


    }

    private class AddCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddCustomerView addCustomerView = new AddCustomerView();
            CustomerController castomerController = new CustomerController(addCustomerView);
            try {
                reportService.save(username, "ADD Customer");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }

        }
    }

    private class UpdateCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateCustomerView updateCustomerView = new UpdateCustomerView();
            CustomerController customerController = new CustomerController(updateCustomerView);
            try {
                reportService.save(username, "UPDATE Customer");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class DeleteCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteCustomerView deleteCustomerView = new DeleteCustomerView();
            CustomerController customerController = new CustomerController(deleteCustomerView);
            try {
                reportService.save(username, "DELETE Customer");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class ViewCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowCustomerView showCustomerView = new ShowCustomerView();
            CustomerController customerController = new CustomerController(showCustomerView);
            try {
                reportService.save(username, "VIEW Customer");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class AddAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddAccountView addAccountView = new AddAccountView();
            AccountController accountController = new AccountController(addAccountView);
            try {
                reportService.save(username, "ADD Account");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class UpdateAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateAccountView updateAccountView = new UpdateAccountView();
            AccountController accountController = new AccountController(updateAccountView);
            try {
                reportService.save(username, "UPDATE Account");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class ViewAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ShowAccountView showAccountView = new ShowAccountView();
            AccountController accountController = new AccountController(showAccountView);
            try {
                reportService.save(username, "VIEW Account");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class DeleteAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteAccountView deleteAccountView = new DeleteAccountView();
            AccountController accountController = new AccountController(deleteAccountView);
            try {
                reportService.save(username, "DELETE Account");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class TransferBetweenAccountsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TransferBeweenAccountsView transferBeweenAccountsView = new TransferBeweenAccountsView();
            TransferMoneyController transferMoneyController = new TransferMoneyController(transferBeweenAccountsView);
            try {
                reportService.save(username, "Transfer money between accounts");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class ProcessUtilitiesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ProcessUtilitiesView processUtilitiesView = new ProcessUtilitiesView();
            ProcessUtilitiesBillsController processUtilitiesBillsController = new ProcessUtilitiesBillsController(processUtilitiesView, username);
            try {
                reportService.save(username, "Process Utilities Bills");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
        }
    }

    private class LogOutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.dispose();
            ComponentFactory componentFactory = ComponentFactory.getInstance();
            new LoginController(new LoginView(), componentFactory.getAuthenticationService());
        }
    }




}
