package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class UpdateEmployeeView extends JFrame {

    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtId;

    private JButton btnUpdate;
    private JButton btnBack;

    public UpdateEmployeeView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtId);
        add(txtUsername);
        add(txtPassword);
        add(btnUpdate);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtId = new JTextField("Type searched user ID");
        txtUsername = new JTextField("Type Username");
        txtPassword = new JTextField("Type Password");

        btnUpdate = new JButton("Update");
        btnBack = new JButton("<-");
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(ActionListener button) {
        this.btnUpdate.addActionListener(button);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }
}
