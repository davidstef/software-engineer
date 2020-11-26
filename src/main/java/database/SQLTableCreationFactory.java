package database;

import static database.Constants.Tables.*;

/**
 * Created by Alex on 11/03/2017.
 */
public class SQLTableCreationFactory {

    public String getCreateSQLForTable(String table) {
        switch (table) {
            case USER:
                return "CREATE TABLE IF NOT EXISTS user (" +
                        "  id INT NOT NULL AUTO_INCREMENT," +
                        "  username VARCHAR(200) NOT NULL," +
                        "  password VARCHAR(64) NOT NULL," +
                        "  PRIMARY KEY (id)," +
                        "  UNIQUE INDEX id_UNIQUE (id ASC)," +
                        "  UNIQUE INDEX username_UNIQUE (username ASC));";

            case CUSTOMER:
                return "CREATE TABLE IF NOT EXISTS repository_customer (" +
                        "  CNP varchar(50) NOT NULL," +
                        "  name varchar(500) NOT NULL," +
                        "  ICN int(15) NOT NULL," +
                        "  adress varchar(500) NOT NULL," +
                        "  phone_number varchar(50) NOT NULL," +
                        "  email varchar(200) NOT NULL," +
                        "  PRIMARY KEY (CNP)," +
                        "  UNIQUE KEY cnp_UNIQUE (CNP)" +
                        ");";

            case ACCOUNT:
                return "CREATE TABLE IF NOT EXISTS repository_account (" +
                        "  id int(11) NOT NULL AUTO_INCREMENT," +
                        "  type varchar(500) NOT NULL," +
                        "  amount_of_money double(10, 2) NOT NULL," +
                        "  date_of_creation datetime DEFAULT NULL," +
                        "  customer_CNP varchar(50) NOT NULL," +
                        "  PRIMARY KEY (id)," +
                        "  UNIQUE KEY id_UNIQUE (id)," +
                        "  CONSTRAINT repository_account_fk1" +
                        "    FOREIGN KEY (customer_CNP)" +
                        "    REFERENCES repository_customer (CNP)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE CASCADE" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=0";

            case SALT:
                return "CREATE TABLE IF NOT EXISTS repository_salt (" +
                    "  user_id int(11) NOT NULL," +
                    "  salt varchar(500) NOT NULL," +
                    "  CONSTRAINT salt_fk" +
                    "    FOREIGN KEY (user_id)" +
                    "    REFERENCES user (id)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE" +
                    ");";

            case TRANSACTION:
                return "CREATE TABLE IF NOT EXISTS repository_transaction (" +
                        "  username varchar(500) NOT NULL," +
                        "  payer_name varchar(300) NOT NULL," +
                        "  id_payer_account int(15) NOT NULL," +
                        "  recipient_account varchar(300) NOT NULL," +
                        "  amount double(10,2) NOT NULL" +
                        ");";

            case REPORT:
                return "CREATE TABLE IF NOT EXISTS repository_report (" +
                        "  id int(15) NOT NULL AUTO_INCREMENT," +
                        "  username varchar(500) NOT NULL," +
                        "  operation varchar(300) NOT NULL," +
                        "  UNIQUE KEY id_UNIQUE (id)," +
                        "  CONSTRAINT repository_report_fk1" +
                        "    FOREIGN KEY (username)" +
                        "    REFERENCES user (username)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE CASCADE" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=1";

            case ROLE:
                return "  CREATE TABLE IF NOT EXISTS role (" +
                        "  id INT NOT NULL AUTO_INCREMENT," +
                        "  role VARCHAR(100) NOT NULL," +
                        "  PRIMARY KEY (id)," +
                        "  UNIQUE INDEX id_UNIQUE (id ASC)," +
                        "  UNIQUE INDEX role_UNIQUE (role ASC));";

            case RIGHT:
                return "  CREATE TABLE IF NOT EXISTS `right` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT," +
                        "  `right` VARCHAR(100) NOT NULL," +
                        "  PRIMARY KEY (`id`)," +
                        "  UNIQUE INDEX `id_UNIQUE` (`id` ASC)," +
                        "  UNIQUE INDEX `right_UNIQUE` (`right` ASC));";

            case ROLE_RIGHT:
                return "  CREATE TABLE IF NOT EXISTS role_right (" +
                        "  id INT NOT NULL AUTO_INCREMENT," +
                        "  role_id INT NOT NULL," +
                        "  right_id INT NOT NULL," +
                        "  PRIMARY KEY (id)," +
                        "  UNIQUE INDEX id_UNIQUE (id ASC)," +
                        "  INDEX role_id_idx (role_id ASC)," +
                        "  INDEX right_id_idx (right_id ASC)," +
                        "  CONSTRAINT role_id" +
                        "    FOREIGN KEY (role_id)" +
                        "    REFERENCES role (id)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE CASCADE," +
                        "  CONSTRAINT right_id" +
                        "    FOREIGN KEY (right_id)" +
                        "    REFERENCES `right` (id)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE CASCADE);";

            case USER_ROLE:
                return "\tCREATE TABLE IF NOT EXISTS user_role (" +
                        "  id INT NOT NULL AUTO_INCREMENT," +
                        "  user_id INT NOT NULL," +
                        "  role_id INT NOT NULL," +
                        "  PRIMARY KEY (id)," +
                        "  UNIQUE INDEX id_UNIQUE (id ASC)," +
                        "  INDEX user_id_idx (user_id ASC)," +
                        "  INDEX role_id_idx (role_id ASC)," +
                        "  CONSTRAINT user_fkid" +
                        "    FOREIGN KEY (user_id)" +
                        "    REFERENCES user (id)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE CASCADE," +
                        "  CONSTRAINT role_fkid" +
                        "    FOREIGN KEY (role_id)" +
                        "    REFERENCES role (id)" +
                        "    ON DELETE CASCADE" +
                        "    ON UPDATE CASCADE);";

            default:
                return "";

        }
    }

}
