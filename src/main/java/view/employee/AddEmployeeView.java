package view.employee;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BoxLayout.Y_AXIS;

public class AddEmployeeView extends JFrame {

    private JTextField txtUsername;
    private JTextField txtPassword;

    private JButton btnAdd;
    private JButton btnBack;

    public AddEmployeeView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtUsername);
        add(txtPassword);
        add(btnAdd);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtUsername = new JTextField("Type Username");
        txtPassword = new JTextField("Type Password");

        btnAdd = new JButton("Add");
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

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }
}
