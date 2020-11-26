package view.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AdministratorView extends JFrame{

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

    private JButton btnAddEmployee;
    private JButton btnUpdateEmployee;
    private JButton btnDeleteEmployee;
    private JButton btnViewEmployee;

    private JButton btnGenerateReports;

    public AdministratorView() throws HeadlessException  {
        setSize(200, 470);
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
        add(btnAddEmployee);
        add(btnUpdateEmployee);
        add(btnDeleteEmployee);
        add(btnViewEmployee);
        add(btnGenerateReports);
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

        btnAddEmployee = new JButton("Add Employee");
        btnUpdateEmployee = new JButton("Update Employee");
        btnViewEmployee = new JButton("View Employee");
        btnDeleteEmployee = new JButton("Delete Employee");

        btnTransferMoney = new JButton("Transfer Money");
        btnProcessUtilities = new JButton("Process Utilities Bills");
        btnGenerateReports = new JButton("Generate Reports");

        btnLogOut = new JButton("Log Out");
    }

    public void setBtnLogOut(ActionListener button) { this.btnLogOut.addActionListener(button); }

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

    public void setBtnDeleteAccount(ActionListener button) { this.btnDeleteAccount.addActionListener(button); }
    public void setBtnViewAccount(ActionListener button) { this.btnViewAccount.addActionListener(button); }

    public void setBtnAddCustomer(ActionListener button) { this.btnAddCustomer.addActionListener(button); }

    public void setBtnUpdateCustomer(ActionListener button) { this.btnUpdateCustomer.addActionListener(button); }

    public void setBtnDeleteCustomer(ActionListener button) { this.btnDeleteCustomer.addActionListener(button); }

    public void setBtnViewCustomer(ActionListener button) { this.btnViewCustomer.addActionListener(button); }

    public void setBtnAddEmployee(ActionListener button) { this.btnAddEmployee.addActionListener(button); }

    public void setBtnUpdateEmployee(ActionListener button) { this.btnUpdateEmployee.addActionListener(button); }

    public void setBtnDeleteEmployee(ActionListener button) { this.btnDeleteEmployee.addActionListener(button); }

    public void setBtnViewEmployee(ActionListener button) { this.btnViewEmployee.addActionListener(button); }

    public void setBtnGenerateReports(ActionListener button) { this.btnGenerateReports.addActionListener(button); }
}
