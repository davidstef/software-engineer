package view.account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AddAccountView extends JFrame{

    private JButton btnAdd;
    private JButton btnBack;
    private JTextField txtCustomerCnp;
    private JTextField txtType;
    private JTextField txtAmountOfMoney;

    public AddAccountView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtCustomerCnp);
        add(txtType);
        add(txtAmountOfMoney);
        add(btnAdd);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtCustomerCnp = new JTextField("Type Customer Cnp");
        txtType = new JTextField("Choose one account type: CURRENT/SAVINGS");
        txtAmountOfMoney = new JTextField("Type amount of money");

        btnAdd = new JButton("Add");
        btnBack = new JButton("<-");
    }

    public void setBtnAdd(ActionListener button) {
        this.btnAdd.addActionListener(button);
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

    public JButton getBtnAdd() {
        return btnAdd;
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

}
