package controller;

import factory.ComponentFactory;
import model.Customer;
import model.builder.CustomerBuilder;
import repository.EntityNotFoundException;
import service.customer.CustomerService;
import service.user.AuthenticationService;
import view.customer.AddCustomerView;
import view.customer.DeleteCustomerView;
import view.customer.ShowCustomerView;
import view.customer.UpdateCustomerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerController {

    private AddCustomerView addCustomerView;
    private ShowCustomerView showCustomerView;
    private UpdateCustomerView updateCustomerView;
    private DeleteCustomerView deleteCustomerView;

    private final ComponentFactory componentFactory;
    private final CustomerService customerService;
    private final AuthenticationService authenticationService;

    public CustomerController (AddCustomerView addCustomerView, AuthenticationService authenticationService) {
        this.addCustomerView = addCustomerView;
        addCustomerView.setBtnAdd(new ButtonAddListener());
        addCustomerView.setBtnBack(new ButtonBackAddListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        customerService = componentFactory.getCustomerService();
    }

    public CustomerController (DeleteCustomerView deleteCustomerView, AuthenticationService authenticationService) {
        this.deleteCustomerView = deleteCustomerView;
        deleteCustomerView.setBtnDelete(new ButtonDeleteListener());
        deleteCustomerView.setBtnBack(new ButtonBackDeleteListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        customerService = componentFactory.getCustomerService();
    }

    public CustomerController (UpdateCustomerView updateCustomerView, AuthenticationService authenticationService) {
        this.updateCustomerView = updateCustomerView;
        updateCustomerView.setBtnUpdate(new ButtonUpdateListener());
        updateCustomerView.setBtnBack(new ButtonBackUpdateListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        customerService = componentFactory.getCustomerService();
    }

    public CustomerController (ShowCustomerView showCustomerView, AuthenticationService authenticationService) {
        this.showCustomerView = showCustomerView;
        showCustomerView.setBtnView(new ButtonViewListener());
        showCustomerView.setBtnBack(new ButtonBackViewListener());
        this.authenticationService = authenticationService;
        componentFactory = ComponentFactory.instance(false);
        customerService = componentFactory.getCustomerService();
    }

    private class ButtonAddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CustomerBuilder customerBuilder = new CustomerBuilder();
            customerBuilder.setCnp(Long.valueOf(addCustomerView.getTxtCnp().getText()));
            customerBuilder.setName(addCustomerView.getTxtName().getText());
            customerBuilder.setIcn(Long.valueOf(addCustomerView.getTxtIcn().getText()));
            customerBuilder.setEmail(addCustomerView.getTxtEmail().getText());
            customerBuilder.setPhoneNumber(Long.valueOf(addCustomerView.getTxtPhoneNumber().getText()));
            customerBuilder.setAdress(addCustomerView.getTxtAdress().getText());
            Customer c = customerBuilder.build();
            try {
                customerService.save(c);
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(addCustomerView.getContentPane(), "The customer have not added!");
            }
        }
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

    private class ButtonUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CustomerBuilder customerBuilder = new CustomerBuilder();
            try {
                Customer customer = customerService.findByCnp(Long.valueOf(updateCustomerView.getTxtCnp().getText()));
                customerBuilder.setName(updateCustomerView.getTxtName().getText());
                customerBuilder.setIcn(Long.valueOf(updateCustomerView.getTxtIcn().getText()));
                customerBuilder.setEmail(updateCustomerView.getTxtEmail().getText());
                customerBuilder.setPhoneNumber(Long.valueOf(updateCustomerView.getTxtPhoneNumber().getText()));
                customerBuilder.setAdress(updateCustomerView.getTxtAdress().getText());
                Customer c = customerBuilder.build();

                customerService.update(c, customer.getCnp());
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(addCustomerView.getContentPane(), "The customer have not updated!");
            }
        }
    }

    private class ButtonDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                customerService.remove(Long.valueOf(deleteCustomerView.getTxtCnp().getText()));
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(deleteCustomerView.getContentPane(), "The customer have not deleted!");
            }
        }
    }

    private class ButtonViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Customer customer = customerService.findByCnp(Long.valueOf(showCustomerView.getTxtCnp().getText()));
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
