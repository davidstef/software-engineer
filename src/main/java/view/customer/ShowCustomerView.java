package view.customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class ShowCustomerView extends JFrame {

    private JTextField txtCnp;

    private JTextField txtName;
    private JTextField txtIcn;
    private JTextField txtAdress;
    private JTextField txtPhoneNumber;
    private JTextField txtEmail;

    private JButton btnView;
    private JButton btnBack;

    public ShowCustomerView() throws HeadlessException {
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
        add(btnView);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtCnp = new JTextField("Type Cnp");
        txtName = new JTextField();
        txtIcn = new JTextField();
        txtAdress = new JTextField();
        txtPhoneNumber = new JTextField();
        txtEmail = new JTextField();

        btnView = new JButton("View");
        btnBack = new JButton("<-");
    }

    public void setTxtCnp(String txtCnp) {
        this.txtCnp.setText(txtCnp);
    }

    public void setTxtName(String txtName) {
        this.txtName.setText(txtName);
    }

    public void setTxtIcn(String txtIcn) {
        this.txtIcn.setText(txtIcn);
    }

    public void setTxtAdress(String txtAdress) {
        this.txtAdress.setText(txtAdress);
    }

    public void setTxtPhoneNumber(String txtPhoneNumber) {
        this.txtPhoneNumber.setText(txtPhoneNumber);
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail.setText(txtEmail);
    }

    public void setBtnView(ActionListener button) {
        this.btnView.addActionListener(button);
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }

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

    public JButton getBtnView() {
        return btnView;
    }

    public JButton getBtnBack() {
        return btnBack;
    }


}
