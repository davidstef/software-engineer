package view.account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class UpdateAccountView extends JFrame {

    private JButton btnUpdate;
    private JButton btnBack;
    private JTextField txtId;
    private JTextField txtCustomerCnp;
    private JTextField txtType;
    private JTextField txtAmountOfMoney;

    public UpdateAccountView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtId);
        add(txtCustomerCnp);
        add(txtType);
        add(txtAmountOfMoney);
        add(btnUpdate);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtId = new JTextField("Type searched account ID");
        txtCustomerCnp = new JTextField("Type customer CNP");
        txtType = new JTextField("Choose one account type: CURRENT/SAVINGS account");
        txtAmountOfMoney = new JTextField("Type amount of money");

        btnUpdate = new JButton("Update");
        btnBack = new JButton("<-");
    }

    public void setBtnUpdate(ActionListener button) {
        this.btnUpdate.addActionListener(button);
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }

    public void setTxtCustomerCnp(JTextField txtCustomerCnp) {
        this.txtCustomerCnp = txtCustomerCnp;
    }

    public void setTxtType(JTextField txtType) {
        this.txtType = txtType;
    }

    public void setTxtAmountOfMoney(JTextField txtAmountOfMoney) {
        this.txtAmountOfMoney = txtAmountOfMoney;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JTextField getTxtCustomerCnp() {
        return txtCustomerCnp;
    }

    public JTextField getTxtType() {
        return txtType;
    }

    public JTextField getTxtAmountOfMoney() {
        return txtAmountOfMoney;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId.setText(txtId);
    }
}
