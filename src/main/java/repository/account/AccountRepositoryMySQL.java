package repository.account;

import model.Account;
import model.builder.AccountBuilder;
import repository.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 07/03/2017.
 */
public class AccountRepositoryMySQL implements AccountRepository {

    private final Connection connection;

    public AccountRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from repository_account";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                accounts.add(getAccountFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public Account findById(Long id) throws EntityNotFoundException {
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from repository_account where id=" + id;
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return getAccountFromResultSet(rs);
            } else {
                throw new EntityNotFoundException(id, Account.class.getSimpleName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EntityNotFoundException(id, Account.class.getSimpleName());
        }
    }

    @Override
    public boolean save(Account account) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO repository_account values (null, ?, ?, ?, ?)");
            insertStatement.setLong(4, account.getCustomerCnp());
            insertStatement.setString(1, account.getType());
            insertStatement.setDate(3, new Date(account.getDateOfCreation().getTime()));
            insertStatement.setDouble(2, account.getAmountOfMoney());
            insertStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean update(Account account, Long id) {
        try {
            PreparedStatement updateStatement = connection
                    .prepareStatement("UPDATE repository_account set customer_CNP=?, repository_account.type=?," +
                            " amount_of_money=?, date_of_creation=? where id=?");
            updateStatement.setLong(1, account.getCustomerCnp());
            updateStatement.setString(2, account.getType());
            updateStatement.setDate(4, new Date(account.getDateOfCreation().getTime()));
            updateStatement.setDouble(3, account.getAmountOfMoney());
            updateStatement.setLong(5, id);
            updateStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Long id) {
        try {
            PreparedStatement deleteStatement = connection
                    .prepareStatement("DELETE from repository_account where id = ?");
            deleteStatement.setLong(1, id);
            deleteStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Account getAccountFromResultSet(ResultSet rs) throws SQLException {
        return new AccountBuilder()
                .setId(rs.getLong("id"))
                .setCustomerCnp(rs.getLong("customer_CNP"))
                .setType(rs.getString("type"))
                .setDateOfCreation(new Date(rs.getDate("date_of_creation").getTime()))
                .setAmountOfMoney(rs.getDouble("amount_of_money"))
                .build();
    }

}
