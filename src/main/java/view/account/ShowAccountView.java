package view.account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class ShowAccountView extends JFrame {

    private JButton btnView;
    private JButton btnBack;
    private JTextField txtId;
    private JTextField txtCustomerCnp;
    private JTextField txtType;
    private JTextField txtDate;
    private JTextField txtAmountOfMoney;

    public ShowAccountView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtId);
        add(txtCustomerCnp);
        add(txtType);
        add(txtDate);
        add(txtAmountOfMoney);
        add(btnView);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtId = new JTextField("Type searched account ID");
        txtCustomerCnp = new JTextField();
        txtType = new JTextField();
        txtDate = new JTextField();
        txtAmountOfMoney = new JTextField();

        btnView = new JButton("View");
        btnBack = new JButton("<-");
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

    public JTextField getTxtCustomerCnp() {
        return txtCustomerCnp;
    }

    public void setTxtCustomerCnp(String txtCustomerCnp) {
        this.txtCustomerCnp.setText(txtCustomerCnp);
    }

    public JTextField getTxtType() {
        return txtType;
    }

    public void setTxtType(String txtType) {
        this.txtType.setText(txtType);
    }

    public JTextField getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate.setText(txtDate);
    }

    public JTextField getTxtAmountOfMoney() {
        return txtAmountOfMoney;
    }

    public void setTxtAmountOfMoney(String txtAmountOfMoney) {
        this.txtAmountOfMoney.setText(txtAmountOfMoney);
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }
}
