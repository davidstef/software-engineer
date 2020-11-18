package view;

import javax.swing.*;
import java.awt.*;
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

    public void setBtnLogOut(JButton btnLogOut) {
        this.btnLogOut = btnLogOut;
    }

    public void setBtnTransferMoney(JButton btnTransferMoney) {
        this.btnTransferMoney = btnTransferMoney;
    }

    public void setBtnProcessUtilities(JButton btnProcessUtilities) {
        this.btnProcessUtilities = btnProcessUtilities;
    }

    public void setBtnAddAccount(JButton btnAddAccount) {
        this.btnAddAccount = btnAddAccount;
    }

    public void setBtnUpdateAccount(JButton btnUpdateAccount) {
        this.btnUpdateAccount = btnUpdateAccount;
    }

    public void setBtnDeleteAccount(JButton btnDeleteAccount) {
        this.btnDeleteAccount = btnDeleteAccount;
    }

    public void setBtnViewAccount(JButton btnViewAccount) {
        this.btnViewAccount = btnViewAccount;
    }

    public void setBtnAddCustomer(JButton btnAddCustomer) {
        this.btnAddCustomer = btnAddCustomer;
    }

    public void setBtnUpdateCustomer(JButton btnUpdateCustomer) {
        this.btnUpdateCustomer = btnUpdateCustomer;
    }

    public void setBtnDeleteCustomer(JButton btnDeleteCustomer) {
        this.btnDeleteCustomer = btnDeleteCustomer;
    }

    public void setBtnViewCustomer(JButton btnViewCustomer) {
        this.btnViewCustomer = btnViewCustomer;
    }

    public void setBtnAddEmployee(JButton btnAddEmployee) {
        this.btnAddEmployee = btnAddEmployee;
    }

    public void setBtnUpdateEmployee(JButton btnUpdateEmployee) {
        this.btnUpdateEmployee = btnUpdateEmployee;
    }

    public void setBtnDeleteEmployee(JButton btnDeleteEmployee) {
        this.btnDeleteEmployee = btnDeleteEmployee;
    }

    public void setBtnViewEmployee(JButton btnViewEmployee) {
        this.btnViewEmployee = btnViewEmployee;
    }

    public void setBtnGenerateReports(JButton btnGenerateReports) {
        this.btnGenerateReports = btnGenerateReports;
    }
}
