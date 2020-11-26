package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class ShowEmployeeView extends JFrame {

    private JTextField txtUsername;
    private JTextField txtId;
    private JTextField txtRole;

    private JButton btnView;
    private JButton btnBack;

    public ShowEmployeeView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtId);
        add(txtUsername);
        add(txtRole);
        add(btnView);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtId = new JTextField("Type searched user ID");
        txtUsername = new JTextField();
        txtRole = new JTextField();

        btnView = new JButton("View");
        btnBack = new JButton("<-");
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername.setText(txtUsername);
    }

    public JButton getBtnView() {
        return btnView;
    }

    public void setBtnView(ActionListener button) {
        this.btnView.addActionListener(button);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }

    public JTextField getTxtRole() {
        return txtRole;
    }

    public void setTxtRole(String txtRole) {
        this.txtRole.setText(txtRole);
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }
}
