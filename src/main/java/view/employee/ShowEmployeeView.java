package view.employee;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BoxLayout.Y_AXIS;

public class ShowEmployeeView extends JFrame {

    private JTextField txtUsername;
    private JTextField txtPassword;

    private JButton btnView;
    private JButton btnBack;

    public ShowEmployeeView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtUsername);
        add(txtPassword);
        add(btnView);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtUsername = new JTextField();
        txtPassword = new JTextField();

        btnView = new JButton("View");
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

    public JButton getBtnView() {
        return btnView;
    }

    public void setBtnView(JButton btnView) {
        this.btnView = btnView;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(JButton btnBack) {
        this.btnBack = btnBack;
    }
}
