package view.customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AddCustomerView extends JFrame {

    private JTextField txtCnp;

    private JTextField txtName;
    private JTextField txtIcn;
    private JTextField txtAdress;
    private JTextField txtPhoneNumber;
    private JTextField txtEmail;

    private JButton btnAdd;
    private JButton btnBack;

    public AddCustomerView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtCnp);
        add(txtName);
        add(txtIcn);
        add(txtAdress);
        add(txtPhoneNumber);
        add(txtEmail);
        add(btnAdd);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtCnp = new JTextField("Type CNP");
        txtName = new JTextField("Type name");
        txtIcn = new JTextField("Type ICN");
        txtAdress = new JTextField("Type Adress");
        txtPhoneNumber = new JTextField("Type Phone Numer");
        txtEmail = new JTextField("Type Email");

        btnAdd = new JButton("Add");
        btnBack = new JButton("<-");
    }

    public void setTxtCnp(JTextField txtCnp) {
        this.txtCnp = txtCnp;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public void setTxtIcn(JTextField txtIcn) {
        this.txtIcn = txtIcn;
    }

    public void setTxtAdress(JTextField txtAdress) {
        this.txtAdress = txtAdress;
    }

    public void setTxtPhoneNumber(JTextField txtPhoneNumber) {
        this.txtPhoneNumber = txtPhoneNumber;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setBtnAdd(ActionListener button) {
        btnAdd.addActionListener(button);
    }

    public void setBtnBack(ActionListener button) { btnBack.addActionListener(button); }

    public JTextField getTxtCnp() {
        return txtCnp;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtIcn() {
        return txtIcn;
    }

    public JTextField getTxtAdress() {
        return txtAdress;
    }

    public JTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnBack() {
        return btnBack;
    }


}
