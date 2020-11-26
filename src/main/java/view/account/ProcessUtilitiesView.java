package view.account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class ProcessUtilitiesView extends JFrame {

    private JButton btnProcess;
    private JButton btnBack;
    private JTextField txtPayerName;
    private JTextField txtIdAccount1;
    private JTextField txtRecipientName;
    private JTextField txtAmountTransferred;

    public ProcessUtilitiesView() throws HeadlessException {
        setSize(250, 300);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtPayerName);
        add(txtIdAccount1);
        add(txtRecipientName);
        add(txtAmountTransferred);
        add(btnProcess);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtPayerName = new JTextField("Type payer account name");
        txtIdAccount1 = new JTextField("Type payer account ID");
        txtRecipientName = new JTextField("Type recipient account name");
        txtAmountTransferred = new JTextField("Type the amount transferred");

        btnProcess = new JButton("Process");
        btnBack = new JButton("<-");
    }

    public JButton getBtnProcess() {
        return btnProcess;
    }

    public void setBtnProcess(ActionListener button) {
        this.btnProcess.addActionListener(button);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }

    public JTextField getTxtPayerName() {
        return txtPayerName;
    }

    public void setTxtPayerName(JTextField txtPayerName) {
        this.txtPayerName = txtPayerName;
    }

    public JTextField getTxtIdAccount1() {
        return txtIdAccount1;
    }

    public void setTxtIdAccount1(JTextField txtIdAccount1) {
        this.txtIdAccount1 = txtIdAccount1;
    }

    public JTextField getTxtRecipientName() {
        return txtRecipientName;
    }

    public void setTxtRecipientName(JTextField txtRecipientName) {
        this.txtRecipientName = txtRecipientName;
    }

    public JTextField getTxtAmountTransferred() {
        return txtAmountTransferred;
    }

    public void setTxtAmountTransferred(JTextField txtAmountTransferred) {
        this.txtAmountTransferred = txtAmountTransferred;
    }
}
