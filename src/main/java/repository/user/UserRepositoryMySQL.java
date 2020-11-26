package repository.user;

import model.User;
import model.builder.UserBuilder;
import service.validation.Notification;
import repository.EntityNotFoundException;
import repository.security.RightsRolesRepository;

import java.sql.*;
import java.util.List;

import static database.Constants.Tables.SALT;
import static database.Constants.Tables.USER;

/**
 * Created by Alex on 11/03/2017.
 */
public class UserRepositoryMySQL implements UserRepository {

    private final Connection connection;
    private final RightsRolesRepository rightsRolesRepository;

    public UserRepositoryMySQL(Connection connection, RightsRolesRepository rightsRolesRepository) {
        this.connection = connection;
        this.rightsRolesRepository = rightsRolesRepository;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Notification<User> findByUsernameAndPassword(String username, String password) throws AuthenticationException {
        Notification<User> findByUsernameAndPasswordNotification = new Notification<>();
        try {
            Statement statement = connection.createStatement();
            String fetchUserSql = "Select * from `" + USER + "` where `username`=\'" + username + "\' and `password`=\'" + password + "\'";
            ResultSet userResultSet = statement.executeQuery(fetchUserSql);
            if (userResultSet.next()) {
                User user = new UserBuilder()
                        .setUsername(userResultSet.getString("username"))
                        .setPassword(userResultSet.getString("password"))
                        .setRoles(rightsRolesRepository.findRolesForUser(userResultSet.getLong("id")))
                        .build();
                findByUsernameAndPasswordNotification.setResult(user);
                return findByUsernameAndPasswordNotification;
            } else {
                findByUsernameAndPasswordNotification.addError("Invalid email or password!");
                return findByUsernameAndPasswordNotification;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AuthenticationException();
        }
    }

    @Override
    public User findByUsername(String username) throws AuthenticationException {
        try {
            Statement statement = connection.createStatement();
            String fetchUserSql = "Select * from `" + USER + "` where `username`=\'" + username + "\'";
            ResultSet userResultSet = statement.executeQuery(fetchUserSql);
            if (userResultSet.next()) {
                User user = new UserBuilder()
                        .setId(userResultSet.getLong("id"))
                        .setUsername(userResultSet.getString("username"))
                        .setPassword(userResultSet.getString("password"))
                        .setRoles(rightsRolesRepository.findRolesForUser(userResultSet.getLong("id")))
                        .build();
                return user;
            }
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AuthenticationException();
        }
    }

    @Override
    public User findById(Long id) {
        try {
            Statement statement = connection.createStatement();
            String fetchUserSql = "Select * from `" + USER + "` where `id`=\'" + id + "\'";
            ResultSet userResultSet = statement.executeQuery(fetchUserSql);
            if (userResultSet.next()) {
                User user = new UserBuilder()
                        .setId(userResultSet.getLong("id"))
                        .setUsername(userResultSet.getString("username"))
                        .setPassword(userResultSet.getString("password"))
                        .setRoles(rightsRolesRepository.findRolesForUser(userResultSet.getLong("id")))
                        .build();
                return user;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(User user, String stringSalt, Long id) {
        try {
            PreparedStatement updateUserStatement = connection
                    .prepareStatement("UPDATE user set user.username=?, user.password=? where id=? ", Statement.RETURN_GENERATED_KEYS);
            updateUserStatement.setString(1, user.getUsername());
            updateUserStatement.setString(2, user.getPassword());
            updateUserStatement.setLong(3, user.getId());
            updateUserStatement.executeUpdate();

            User searchedUser = findById(id);
            user.setId(searchedUser.getId());
            rightsRolesRepository.addRolesToUser(user, user.getRoles());

            PreparedStatement insertSaltStatement = connection
                    .prepareStatement("UPDATE repository_salt SET salt=? where user_id=? ", Statement.RETURN_GENERATED_KEYS);
            insertSaltStatement.setLong(2, searchedUser.getId());
            insertSaltStatement.setString(1, stringSalt);
            insertSaltStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(User user, String stringSalt) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO user values (null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, user.getUsername());
            insertUserStatement.setString(2, user.getPassword());
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            long userId = rs.getLong(1);
            user.setId(userId);

            rightsRolesRepository.addRolesToUser(user, user.getRoles());

            PreparedStatement insertSaltStatement = connection
                    .prepareStatement("INSERT INTO repository_salt values (?, ?)");
            insertSaltStatement.setLong(1, userId);
            insertSaltStatement.setString(2, stringSalt);
            insertSaltStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Long id) throws EntityNotFoundException {
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE from user where id=" + id;
            statement.executeUpdate(sql);
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
            String sql = "DELETE from user where id >= 0";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findSaltByUsername(String username) throws AuthenticationException {
        User user = findByUsername(username);
        try {
            Statement statement = connection.createStatement();
            String sql =  "Select * from `" + SALT + "` where `user_id`=\'" + user.getId() + "\'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
