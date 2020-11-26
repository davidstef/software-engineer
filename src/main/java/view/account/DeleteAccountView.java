package view.account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class DeleteAccountView extends JFrame {

    private JButton btnDelete;
    private JButton btnBack;
    private JTextField txtId;


    public DeleteAccountView() throws HeadlessException {
        setSize(250, 200);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtId);
        add(btnDelete);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtId = new JTextField("Type Account ID");

        btnDelete = new JButton("Delete");
        btnBack = new JButton("<-");
    }

    public void setBtnDelete(ActionListener button) {
        this.btnDelete.addActionListener(button);
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JTextField getTxtId() {
        return txtId;
    }
}
