package view.customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class DeleteCustomerView extends JFrame {

    private JTextField txtCnp;

    private JButton btnDelete;
    private JButton btnBack;

    public DeleteCustomerView() throws HeadlessException {
        setSize(250, 150);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtCnp);
        add(btnDelete);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtCnp = new JTextField("Type Customer CNP");

        btnDelete = new JButton("Delete");
        btnBack = new JButton("<-");
    }

    public JTextField getTxtCnp() {
        return txtCnp;
    }

    public void setTxtCnp(JTextField txtCnp) {
        this.txtCnp = txtCnp;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(ActionListener button) {
        this.btnDelete.addActionListener(button);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }
}
