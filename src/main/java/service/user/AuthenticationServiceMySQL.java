package service.user;

import model.Role;
import model.User;
import model.builder.UserBuilder;
import service.validation.Notification;
import service.validation.UserValidator;
import repository.security.RightsRolesRepository;
import repository.user.AuthenticationException;
import repository.user.UserRepository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Collections;

import static database.Constants.Roles.ADMINISTRATOR;
import static database.Constants.Roles.EMPLOYEE;

/**
 * Created by Alex on 11/03/2017.
 */
public class AuthenticationServiceMySQL implements AuthenticationService {

    private final UserRepository userRepository;
    private final RightsRolesRepository rightsRolesRepository;

    public AuthenticationServiceMySQL(UserRepository userRepository, RightsRolesRepository rightsRolesRepository) {
        this.userRepository = userRepository;
        this.rightsRolesRepository = rightsRolesRepository;
    }

    @Override
    public Notification<Boolean> register(String username, String password) throws UnsupportedEncodingException {
        Role customerRole = rightsRolesRepository.findRoleByTitle(ADMINISTRATOR);
        User user = new UserBuilder()
                .setUsername(username)
                .setPassword(password)
                .setRoles(Collections.singletonList(customerRole))
                .build();

        UserValidator userValidator = new UserValidator(user);
        boolean userValid = userValidator.validate();
        Notification<Boolean> userRegisterNotification = new Notification<>();

        if (!userValid) {
            userValidator.getErrors().forEach(userRegisterNotification::addError);
            userRegisterNotification.setResult(Boolean.FALSE);
        } else {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            String stringSalt = salt.toString();

            user.setPassword(encodePassword(password, stringSalt));
            userRegisterNotification.setResult(userRepository.save(user, stringSalt));
        }
        return userRegisterNotification;
    }

    @Override
    public Notification<User> login(String username, String password) throws AuthenticationException {
        return userRepository.findByUsernameAndPassword(username, encodePassword(password, findSaltByUsername(username)));
    }

    @Override
    public boolean logout(User user) {
        return false;
    }

    @Override
    public String findSaltByUsername(String username)  {
        try {
            return userRepository.findSaltByUsername(username);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String encodePassword(String password, String stringSalt) {
        try {
            byte[] salt = stringSalt.getBytes("UTF-8");
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(salt);

            byte[] hash = digest.digest(password.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
