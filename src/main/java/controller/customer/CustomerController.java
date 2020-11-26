package controller.customer;

import factory.ComponentFactory;
import model.Customer;
import model.builder.CustomerBuilder;
import service.validation.Notification;
import repository.EntityNotFoundException;
import service.customer.CustomerService;
import service.validation.ResultFetchException;
import view.customer.AddCustomerView;
import view.customer.DeleteCustomerView;
import view.customer.ShowCustomerView;
import view.customer.UpdateCustomerView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLTransientException;

public class CustomerController {

    private AddCustomerView addCustomerView;
    private ShowCustomerView showCustomerView;
    private UpdateCustomerView updateCustomerView;
    private DeleteCustomerView deleteCustomerView;

    private final ComponentFactory componentFactory;
    private CustomerService customerService;

    public CustomerController (AddCustomerView addCustomerView) {
        this.addCustomerView = addCustomerView;
        addCustomerView.setBtnAdd(new ButtonAddListener());
        addCustomerView.setBtnBack(new ButtonBackAddListener());
        componentFactory = ComponentFactory.getInstance();
        customerService = componentFactory.getCustomerService();
    }

    public CustomerController (DeleteCustomerView deleteCustomerView) {
        this.deleteCustomerView = deleteCustomerView;
        deleteCustomerView.setBtnDelete(new ButtonDeleteListener());
        deleteCustomerView.setBtnBack(new ButtonBackDeleteListener());
        componentFactory = ComponentFactory.getInstance();
        customerService = componentFactory.getCustomerService();
    }

    public CustomerController (UpdateCustomerView updateCustomerView) {
        this.updateCustomerView = updateCustomerView;
        updateCustomerView.setBtnUpdate(new ButtonUpdateListener());
        updateCustomerView.setBtnBack(new ButtonBackUpdateListener());
        componentFactory = ComponentFactory.getInstance();
        customerService = componentFactory.getCustomerService();
    }

    public CustomerController (ShowCustomerView showCustomerView) {
        this.showCustomerView = showCustomerView;
        showCustomerView.setBtnView(new ButtonViewListener());
        showCustomerView.setBtnBack(new ButtonBackViewListener());

        componentFactory = ComponentFactory.getInstance();
        customerService = componentFactory.getCustomerService();
    }

    private class ButtonBackAddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addCustomerView.setVisible(false);
        }
    }

    private class ButtonBackUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateCustomerView.setVisible(false);
        }
    }

    private class ButtonBackDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteCustomerView.setVisible(false);
        }
    }

    private class ButtonBackViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            showCustomerView.setVisible(false);
        }
    }

    private class ButtonAddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CustomerBuilder customerBuilder = new CustomerBuilder();
            customerBuilder.setCnp(addCustomerView.getTxtCnp().getText());
            customerBuilder.setName(addCustomerView.getTxtName().getText());
            customerBuilder.setIcn(Long.valueOf(addCustomerView.getTxtIcn().getText()));
            customerBuilder.setEmail(addCustomerView.getTxtEmail().getText());
            customerBuilder.setPhoneNumber(addCustomerView.getTxtPhoneNumber().getText());
            customerBuilder.setAdress(addCustomerView.getTxtAdress().getText());
            Customer c = customerBuilder.build();

            Notification<Boolean> customerAddNotification = null;
            try {
                customerAddNotification = customerService.save(c);
                if(customerAddNotification.getResult() == false) {
                    JOptionPane.showMessageDialog(addCustomerView.getContentPane(), "The customer already exists!");
                }
                if(customerAddNotification.hasErrors()) {
                    JOptionPane.showMessageDialog(addCustomerView.getContentPane(), customerAddNotification.getFormattedErrors());
                }
            } catch (SQLException ec) {
                JOptionPane.showMessageDialog(addCustomerView.getContentPane(), "The customer already exists 1!");
            } catch (ResultFetchException ec) {
                JOptionPane.showMessageDialog(addCustomerView.getContentPane(), customerAddNotification.getFormattedErrors());
            }
        }
    }

    private class ButtonUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CustomerBuilder customerBuilder = new CustomerBuilder();
            try {
                Customer customer = customerService.findByCnp(updateCustomerView.getTxtCnp().getText());
                customerBuilder.setName(updateCustomerView.getTxtName().getText());
                customerBuilder.setIcn(Long.valueOf(updateCustomerView.getTxtIcn().getText()));
                customerBuilder.setEmail(updateCustomerView.getTxtEmail().getText());
                customerBuilder.setPhoneNumber(updateCustomerView.getTxtPhoneNumber().getText());
                customerBuilder.setAdress(updateCustomerView.getTxtAdress().getText());
                Customer c = customerBuilder.build();

                Notification<Boolean> customerUpdateNotification;
                customerUpdateNotification = customerService.update(c, customer.getCnp());
                if (customerUpdateNotification.hasErrors()) {
                    JOptionPane.showMessageDialog(updateCustomerView.getContentPane(), customerUpdateNotification.getFormattedErrors());
                }

            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(updateCustomerView.getContentPane(), "The customer have not found!");
            }
        }
    }

    private class ButtonDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                customerService.remove(deleteCustomerView.getTxtCnp().getText());
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(deleteCustomerView.getContentPane(), "The customer have not deleted!");
            }
        }
    }

    private class ButtonViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Customer customer = customerService.findByCnp(showCustomerView.getTxtCnp().getText());
                showCustomerView.setTxtName("Name: " + customer.getName());
                showCustomerView.setTxtAdress("Adress: " + customer.getAdress());
                showCustomerView.setTxtPhoneNumber("Phone Number: " + customer.getPhoneNumber());
                showCustomerView.setTxtIcn("ICN: " + customer.getIcn());
                showCustomerView.setTxtEmail("E-mail: " + customer.getEmail());

            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(deleteCustomerView.getContentPane(), "The customer could not be found!");
            }
        }
    }
}
