package repository.transaction;

import model.Transaction;
import model.builder.TransactionBuilder;
import repository.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryMySQL implements TransactionRepository {

    private final Connection connection;

    public TransactionRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Transaction> findByUsername(String username) throws EntityNotFoundException {
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from repository_customer where cnp=" + username;
            ResultSet rs = statement.executeQuery(sql);
            List<Transaction> transactions = new ArrayList<Transaction>();
            while(rs.next()) {
                transactions.add(getTransactionFromResultSet(rs));
            }
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EntityNotFoundException(username, Transaction.class.getSimpleName());
        }
    }

    @Override
    public boolean save(Transaction transaction) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO repository_transaction values (?, ?, ?, ?, ?)");
            insertStatement.setString(1, transaction.getUsername());
            insertStatement.setString(2, transaction.getPayerName());
            insertStatement.setLong(3, transaction.getIdPayerAccount());
            insertStatement.setString(4, transaction.getRecipientName());
            insertStatement.setDouble(5, transaction.getAmount());
            insertStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Transaction getTransactionFromResultSet(ResultSet rs) throws SQLException {
        return new TransactionBuilder()
                .setUsername(rs.getString("username"))
                .setIdPayerAccount(rs.getLong("id_payer_account"))
                .setPayerName(rs.getString("payer_account"))
                .setRecipientName(rs.getString("recipient_account"))
                .setAmount(rs.getDouble("amount"))
                .build();
    }
}
