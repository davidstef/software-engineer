package view.customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class UpdateCustomerView extends JFrame {

    private JTextField txtCnp;

    private JTextField txtName;
    private JTextField txtIcn;
    private JTextField txtAdress;
    private JTextField txtPhoneNumber;
    private JTextField txtEmail;

    private JButton btnUpdate;
    private JButton btnBack;

    public UpdateCustomerView() throws HeadlessException {
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
        add(btnUpdate);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtCnp = new JTextField("Type Cnp");
        txtName = new JTextField("Type Name");
        txtIcn = new JTextField("Type ICN");
        txtAdress = new JTextField("Type Adress");
        txtPhoneNumber = new JTextField("Type Phone Number");
        txtEmail = new JTextField("Type Email");

        btnUpdate = new JButton("Update");
        btnBack = new JButton("<-");
    }

    public JTextField getTxtCnp() {
        return txtCnp;
    }

    public void setTxtCnp(JTextField txtCnp) {
        this.txtCnp = txtCnp;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtIcn() {
        return txtIcn;
    }

    public void setTxtIcn(JTextField txtIcn) {
        this.txtIcn = txtIcn;
    }

    public JTextField getTxtAdress() {
        return txtAdress;
    }

    public void setTxtAdress(JTextField txtAdress) {
        this.txtAdress = txtAdress;
    }

    public JTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public void setTxtPhoneNumber(JTextField txtPhoneNumber) {
        this.txtPhoneNumber = txtPhoneNumber;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
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
}
