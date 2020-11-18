package database;

import java.util.*;

import static database.Constants.Rights.*;
import static database.Constants.Roles.*;

/**
 * Created by Alex on 11/03/2017.
 */
public class Constants {

    public static class Schemas {
        public static final String TEST = "test_bank";
        public static final String PRODUCTION = "bank";

        public static final String[] SCHEMAS = new String[]{TEST, PRODUCTION};
    }

    public static class Tables {
        public static final String ACCOUNT = "repository_account";
        public static final String CUSTOMER = "repository_customer";
        public static final String TRANSACTION = "repository_transaction";
        public static final String USER = "user";
        public static final String ROLE = "role";
        public static final String RIGHT = "right";
        public static final String ROLE_RIGHT = "role_right";
        public static final String USER_ROLE = "user_role";

        public static final String[] ORDERED_TABLES_FOR_CREATION = new String[]{USER, ROLE, RIGHT, ROLE_RIGHT, USER_ROLE, CUSTOMER, ACCOUNT, TRANSACTION};
    }

    public static class Roles {
        public static final String ADMINISTRATOR = "administrator";
        public static final String EMPLOYEE = "employee";

        public static final String[] ROLES = new String[]{ADMINISTRATOR, EMPLOYEE};
    }

    public static class Rights {
        public static final String ADD_CUSTOMER = "add_customer";
        public static final String VIEW_CUSTOMER = "view_customer";
        public static final String UPDATE_CUSTOMER = "update_customer";

        public static final String CREATE_ACCOUNT = "create_account";
        public static final String DELETE_ACCOUNT = "delete_account";
        public static final String VIEW_ACCOUNT = "view_book";
        public static final String UPDATE_ACCOUNT = "update_account";

        public static final String CREATE_EMPLOYEE = "create_employee";
        public static final String DELETE_EMPLOYEE = "delete_employee";
        public static final String VIEW_EMPLOYEE = "view_employee";
        public static final String UPDATE_EMPLOYEE = "update_employee";

        public static final String TRANSFER_MONEY_BETWEEN_ACCOUNTS = "transfer_money_between_accounts";
        public static final String GENERATE_BILL = "generate_bill";
        public static final String GENERATE_REPORTS = "generate_reports";

        public static final String[] RIGHTS = new String[]{ADD_CUSTOMER,VIEW_CUSTOMER,UPDATE_CUSTOMER,CREATE_ACCOUNT,DELETE_ACCOUNT,VIEW_ACCOUNT,
                UPDATE_ACCOUNT,CREATE_EMPLOYEE,DELETE_EMPLOYEE,VIEW_EMPLOYEE,UPDATE_EMPLOYEE,TRANSFER_MONEY_BETWEEN_ACCOUNTS,GENERATE_BILL,GENERATE_REPORTS};
        public static final String[] RIGHTS_EMPLOYEE = new String[]{ADD_CUSTOMER,VIEW_CUSTOMER,UPDATE_CUSTOMER,CREATE_ACCOUNT,DELETE_ACCOUNT,VIEW_ACCOUNT,
                UPDATE_ACCOUNT,TRANSFER_MONEY_BETWEEN_ACCOUNTS,GENERATE_BILL};
    }

    public static Map<String, List<String>> getRolesRights() {
        Map<String, List<String>> ROLES_RIGHTS = new HashMap<>();
        for (String role : ROLES) {
            ROLES_RIGHTS.put(role, new ArrayList<>());
        }

        ROLES_RIGHTS.get(EMPLOYEE).addAll(Arrays.asList(ADD_CUSTOMER,VIEW_CUSTOMER,UPDATE_CUSTOMER,CREATE_ACCOUNT,DELETE_ACCOUNT,VIEW_ACCOUNT,
                UPDATE_ACCOUNT,TRANSFER_MONEY_BETWEEN_ACCOUNTS,GENERATE_BILL));

        ROLES_RIGHTS.get(ADMINISTRATOR).addAll(Arrays.asList(RIGHTS));

        return ROLES_RIGHTS;
    }

}
