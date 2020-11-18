package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class EmployeeView extends JFrame{

    private JButton btnLogOut;

    private JButton btnTransferMoney;
    private JButton btnProcessUtilities;

    private JButton btnAddAccount;
    private JButton btnUpdateAccount;
    private JButton btnDeleteAccount;
    private JButton btnViewAccount;
    private JButton btnAddCustomer;
    private JButton btnUpdateCustomer;
    private JButton btnDeleteCustomer;
    private JButton btnViewCustomer;


    public EmployeeView() throws HeadlessException  {
        setSize(200, 350);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(btnAddAccount);
        add(btnUpdateAccount);
        add(btnViewAccount);
        add(btnDeleteAccount);
        add(btnAddCustomer);
        add(btnUpdateCustomer);
        add(btnViewCustomer);
        add(btnDeleteCustomer);
        add(btnTransferMoney);
        add(btnProcessUtilities);
        add(btnLogOut);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {

        btnAddAccount = new JButton("Add Account");
        btnDeleteAccount = new JButton("Delete Account");
        btnUpdateAccount = new JButton("Update Account");
        btnViewAccount = new JButton("View Account");

        btnAddCustomer = new JButton("Add Customer");
        btnUpdateCustomer = new JButton("Update Customer");
        btnViewCustomer = new JButton("View Customer");
        btnDeleteCustomer = new JButton("Delete Customer");

        btnTransferMoney = new JButton("Transfer Money");
        btnProcessUtilities = new JButton("Process Utilities Bills");
        btnLogOut = new JButton("Log Out");
    }

    public void setBtnLogOut(ActionListener button) {
        this.btnLogOut.addActionListener(button);
    }

    public void setBtnTransferMoney(ActionListener button) {
        this.btnTransferMoney.addActionListener(button);
    }

    public void setBtnProcessUtilities(ActionListener button) {
        this.btnProcessUtilities.addActionListener(button);
    }

    public void setBtnAddAccount(ActionListener button) {
        this.btnAddAccount.addActionListener(button);
    }

    public void setBtnUpdateAccount(ActionListener button) {
        this.btnUpdateAccount.addActionListener(button);
    }

    public void setBtnDeleteAccount(ActionListener button) {
        this.btnDeleteAccount.addActionListener(button);
    }

    public void setBtnViewAccount(ActionListener button) { this.btnViewAccount.addActionListener(button); }

    public void setBtnAddCustomer(ActionListener button) { this.btnAddCustomer.addActionListener(button); }

    public void setBtnUpdateCustomer(ActionListener button) {
        this.btnUpdateCustomer.addActionListener(button);
    }

    public void setBtnDeleteCustomer(ActionListener button) {
        this.btnDeleteCustomer.addActionListener(button);
    }

    public void setBtnViewCustomer(ActionListener button) {
        this.btnViewCustomer.addActionListener(button);
    }
}
