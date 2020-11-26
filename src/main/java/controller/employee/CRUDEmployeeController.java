package controller.employee;

import factory.ComponentFactory;
import model.User;
import service.validation.Notification;
import repository.EntityNotFoundException;
import service.user.UserService;
import view.employee.AddEmployeeView;
import view.employee.DeleteEmployeeView;
import view.employee.ShowEmployeeView;
import view.employee.UpdateEmployeeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

public class CRUDEmployeeController {

    AddEmployeeView addEmployeeView;
    ShowEmployeeView showEmployeeView;
    UpdateEmployeeView updateEmployeeView;
    DeleteEmployeeView deleteEmployeeView;

    private final ComponentFactory componentFactory;
    private UserService userService;

    public CRUDEmployeeController(AddEmployeeView addEmployeeView) {
        this.addEmployeeView = addEmployeeView;
        addEmployeeView.setBtnAdd(new ButtonAddListener());
        addEmployeeView.setBtnBack(new ButtonBackAddListener());
        componentFactory = ComponentFactory.getInstance();
        userService = componentFactory.getUserService();
    }

    public CRUDEmployeeController(ShowEmployeeView showEmployeeView) {
        this.showEmployeeView = showEmployeeView;
        showEmployeeView.setBtnView(new ButtonViewListener());
        showEmployeeView.setBtnBack(new ButtonBackViewListener());
        componentFactory = ComponentFactory.getInstance();
        userService = componentFactory.getUserService();
    }

    public CRUDEmployeeController(UpdateEmployeeView updateEmployeeView) {
        this.updateEmployeeView = updateEmployeeView;
        updateEmployeeView.setBtnUpdate(new ButtonUpdateListener());
        updateEmployeeView.setBtnBack(new ButtonBackUpdateListener());
        componentFactory = ComponentFactory.getInstance();
        userService = componentFactory.getUserService();
    }

    public CRUDEmployeeController(DeleteEmployeeView deleteEmployeeView) {
        this.deleteEmployeeView = deleteEmployeeView;
        deleteEmployeeView.setBtnDelete(new ButtonDeleteListener());
        deleteEmployeeView.setBtnBack(new ButtonBackDeleteListener());
        componentFactory = ComponentFactory.getInstance();
        userService = componentFactory.getUserService();
    }

    private class ButtonBackAddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addEmployeeView.setVisible(false);
        }
    }

    private class ButtonBackUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateEmployeeView.setVisible(false);
        }
    }

    private class ButtonBackDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteEmployeeView.setVisible(false);
        }
    }

    private class ButtonBackViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            showEmployeeView.setVisible(false);
        }
    }

    private class ButtonAddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = addEmployeeView.getTxtUsername().getText();
            String password = addEmployeeView.getTxtPassword().getText();

            Notification<Boolean> addNotification = null;
            try {
                addNotification = userService.save(username, password);
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
            if (addNotification.hasErrors()) {
                JOptionPane.showMessageDialog(addEmployeeView.getContentPane(), addNotification.getFormattedErrors());
            } else {
                if (!addNotification.getResult()) {
                    JOptionPane.showMessageDialog(addEmployeeView.getContentPane(), "Registration not successful, please try again later.");
                } else {
                    JOptionPane.showMessageDialog(addEmployeeView.getContentPane(), "Registration successful!");
                }
            }
        }
    }

    private class ButtonUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Long id = Long.valueOf(updateEmployeeView.getTxtId().getText());
            String username = updateEmployeeView.getTxtUsername().getText();
            String password = updateEmployeeView.getTxtPassword().getText();

            Notification<Boolean> updateNotification = null;
            try {
                updateNotification = userService.update(username, password, id);
            } catch (UnsupportedOperationException ex) {
                ex.printStackTrace();
            }
            if (updateNotification.hasErrors()) {
                JOptionPane.showMessageDialog(updateEmployeeView.getContentPane(), updateNotification.getFormattedErrors());
            } else {
                if (!updateNotification.getResult()) {
                    JOptionPane.showMessageDialog(updateEmployeeView.getContentPane(), "Registration not successful, please try again later.");
                } else {
                    JOptionPane.showMessageDialog(updateEmployeeView.getContentPane(), "Registration successful!");
                }
            }
        }
    }

    private class ButtonViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                User user = userService.findById(Long.valueOf(showEmployeeView.getTxtId().getText()));
                showEmployeeView.setTxtUsername("Username: " + user.getUsername());
                showEmployeeView.setTxtRole("Role: " + user.getRoles().get(0).getRole());
            } catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(showEmployeeView.getContentPane(), "The user could not be found!");
            } catch (NumberFormatException numer) {
                JOptionPane.showMessageDialog(showEmployeeView.getContentPane(), "Invalid ID!");
            }
        }
    }

    private class ButtonDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                userService.remove(Long.valueOf(deleteEmployeeView.getTxtId().getText()));
            } catch (EntityNotFoundException entityNotFoundException) {
                    JOptionPane.showMessageDialog(showEmployeeView.getContentPane(), "The user could not be found!");
            } catch (NumberFormatException numer) {
                    JOptionPane.showMessageDialog(showEmployeeView.getContentPane(), "Invalid ID!");
            }
        }
    }


}
