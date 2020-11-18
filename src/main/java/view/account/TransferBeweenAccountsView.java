package view.account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class TransferBeweenAccountsView extends JFrame{

    private JButton btnTransfer;
    private JButton btnBack;
    private JTextField txtIdAccount1;
    private JTextField txtIdAccount2;
    private JTextField txtAmountTransferred;

    public TransferBeweenAccountsView() throws HeadlessException {
        setSize(250, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtIdAccount1);
        add(txtIdAccount2);
        add(txtAmountTransferred);
        add(btnTransfer);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtIdAccount1 = new JTextField("Type payer account ID");
        txtIdAccount2 = new JTextField("Type recipient account ID");
        txtAmountTransferred = new JTextField("Type the amount transferred");

        btnTransfer = new JButton("Transfer");
        btnBack = new JButton("<-");
    }

    public JButton getBtnTransfer() {
        return btnTransfer;
    }

    public void setBtnTransfer(ActionListener button) {
        this.btnTransfer.addActionListener(button);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }

    public JTextField getTxtIdAccount1() {
        return txtIdAccount1;
    }

    public void setTxtIdAccount1(JTextField txtIdAccount1) {
        this.txtIdAccount1 = txtIdAccount1;
    }

    public JTextField getTxtIdAccount2() {
        return txtIdAccount2;
    }

    public void setTxtIdAccount2(JTextField txtIdAccount2) {
        this.txtIdAccount2 = txtIdAccount2;
    }

    public JTextField getTxtAmountTransferred() {
        return txtAmountTransferred;
    }

    public void setTxtAmountTransferred(JTextField txtAmountTransferred) {
        this.txtAmountTransferred = txtAmountTransferred;
    }
}
