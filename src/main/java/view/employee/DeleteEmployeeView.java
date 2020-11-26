package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class DeleteEmployeeView extends JFrame{

    private JTextField txtId;


    private JButton btnDelete;
    private JButton btnBack;

    public DeleteEmployeeView() throws HeadlessException {
        setSize(250, 500);
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
        txtId = new JTextField("Type User ID");

        btnDelete = new JButton("Delete");
        btnBack = new JButton("<-");
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(ActionListener btn) {
        this.btnDelete.addActionListener(btn);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(ActionListener btn) {
        this.btnBack.addActionListener(btn);
    }
}
