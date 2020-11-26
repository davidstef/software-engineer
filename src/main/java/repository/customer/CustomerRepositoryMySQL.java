package repository.customer;

import model.Customer;
import model.builder.CustomerBuilder;
import repository.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryMySQL implements CustomerRepository {

    private final Connection connection;

    public CustomerRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from repository_customer";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                customers.add(getCustomerFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
    public Customer findByCnp(String cnp) throws EntityNotFoundException {
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from repository_customer where cnp=" + cnp;
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return getCustomerFromResultSet(rs);
            } else {
                throw new EntityNotFoundException(cnp, Customer.class.getSimpleName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EntityNotFoundException(cnp, Customer.class.getSimpleName());
        }
    }

    @Override
    public boolean save(Customer customer) {
        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO repository_customer values (?, ?, ?, ?, ?, ?)");
            insertStatement.setString(1, customer.getCnp());
            insertStatement.setString(2, customer.getName());
            insertStatement.setLong(3, customer.getIcn());
            insertStatement.setString(4, customer.getAdress());
            insertStatement.setString(5, customer.getPhoneNumber());
            insertStatement.setString(6, customer.getEmail());
            insertStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("The customer already exists.");
            return false;
        }
    }

    @Override
    public boolean update(Customer customer, String cnp) {
        try {
            PreparedStatement updateStatement = connection
                    .prepareStatement("UPDATE repository_customer set repository_customer.name=?," +
                            " ICN=?, adress=?, phone_number=?, email=? where cnp=?");
            updateStatement.setString(1, customer.getName());
            updateStatement.setLong(2, customer.getIcn());
            updateStatement.setString(3, customer.getAdress());
            updateStatement.setString(4, customer.getPhoneNumber());
            updateStatement.setString(5, customer.getEmail());
            updateStatement.setString(6, cnp);
            updateStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(String cnp) {
        try {
            PreparedStatement deleteStatement = connection
                    .prepareStatement("DELETE from repository_customer where cnp = ?");
            deleteStatement.setString(1, cnp);
            deleteStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void removeAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE from repository_customer where cnp >= 0";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer getCustomerFromResultSet(ResultSet rs) throws SQLException {
        return new CustomerBuilder()
                .setCnp(rs.getString("CNP"))
                .setName(rs.getString("name"))
                .setIcn(rs.getLong("ICN"))
                .setAdress(rs.getString("adress"))
                .setPhoneNumber(rs.getString("phone_number"))
                .setEmail(rs.getString("email"))
                .build();
    }

}
