package factory;

import database.DBConnectionFactory;
import repository.account.AccountRepository;
import repository.account.AccountRepositoryMySQL;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryMySQL;
import repository.report.ReportRepository;
import repository.report.ReportRepositoryMySQL;
import repository.security.RightsRolesRepository;
import repository.security.RightsRolesRepositoryMySQL;
import repository.transaction.TransactionRepository;
import repository.transaction.TransactionRepositoryMySQL;
import repository.user.UserRepository;
import repository.user.UserRepositoryMySQL;
import service.account.AccountService;
import service.account.AccountServiceImpl;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.report.ReportService;
import service.report.ReportServiceImpl;
import service.transaction.TransactionService;
import service.transaction.TransactionServiceImpl;
import service.user.AuthenticationService;
import service.user.AuthenticationServiceMySQL;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.sql.Connection;

/**
 * Created by Alex on 18/03/2017.
 */
public class ComponentFactory {

    private final AuthenticationService authenticationService;
    private final AccountService accountService;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final UserService userService;
    private final ReportService reportService;

    private final UserRepository userRepository;
    private final RightsRolesRepository rightsRolesRepository;
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final ReportRepository reportRepository;

    private static ComponentFactory instance;

    public static ComponentFactory instance(Boolean componentsForTests) {
        if (instance == null) {
            instance = new ComponentFactory(componentsForTests);
        }
        return instance;
    }

    private ComponentFactory(Boolean componentsForTests) {
        Connection connection = new DBConnectionFactory().getConnectionWrapper(componentsForTests).getConnection();
        this.rightsRolesRepository = new RightsRolesRepositoryMySQL(connection);
        this.userRepository = new UserRepositoryMySQL(connection, rightsRolesRepository);
        this.authenticationService = new AuthenticationServiceMySQL(this.userRepository, this.rightsRolesRepository);
        this.userService = new UserServiceImpl(userRepository, rightsRolesRepository);

        this.accountRepository = new AccountRepositoryMySQL(connection);
        this.accountService = new AccountServiceImpl(this.accountRepository);
        this.customerRepository = new CustomerRepositoryMySQL(connection);
        this.customerService = new CustomerServiceImpl(this.customerRepository);
        this.transactionRepository = new TransactionRepositoryMySQL(connection);
        this.transactionService = new TransactionServiceImpl(transactionRepository);

        this.reportRepository = new ReportRepositoryMySQL(connection);
        this.reportService = new ReportServiceImpl(reportRepository);

    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public RightsRolesRepository getRightsRolesRepository() {
        return rightsRolesRepository;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public static ComponentFactory getInstance() {
        return instance;
    }

    public CustomerService getCustomerService() { return customerService; }

    public CustomerRepository getCustomerRepository() { return customerRepository; }

    public TransactionService getTransactionService() {
        return transactionService;
    }

    public UserService getUserService() {
        return userService;
    }

    public TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    public ReportService getReportService() {
        return reportService;
    }
}
