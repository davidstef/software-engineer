package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class GenerateReportsView extends JFrame {

    private JTextField txtStart;
    private JTextField txtEnd;
    private JTextField txtUsername;

    private JButton btnGenerate;
    private JButton btnBack;

    public GenerateReportsView() throws HeadlessException {
        setSize(250, 500);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(txtUsername);
        add(txtStart);
        add(txtEnd);
        add(btnGenerate);
        add(btnBack);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {
        txtUsername = new JTextField("Type Employee Username");
        txtStart = new JTextField("Type Start Time");
        txtEnd = new JTextField("Type End Time");

        btnGenerate = new JButton("Generate Reports");
        btnBack = new JButton("<-");
    }

    public JTextField getTxtStart() {
        return txtStart;
    }

    public void setTxtStart(JTextField txtStart) {
        this.txtStart = txtStart;
    }

    public JTextField getTxtEnd() {
        return txtEnd;
    }

    public void setTxtEnd(JTextField txtEnd) {
        this.txtEnd = txtEnd;
    }

    public JButton getBtnGenerate() {
        return btnGenerate;
    }

    public void setBtnGenerate(ActionListener button) {
        this.btnGenerate.addActionListener(button);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(ActionListener button) {
        this.btnBack.addActionListener(button);
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }
}
