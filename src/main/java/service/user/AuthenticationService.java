package service.user;

import model.User;
import service.validation.Notification;
import repository.user.AuthenticationException;

import java.io.UnsupportedEncodingException;

/**
 * Created by Alex on 11/03/2017.
 */
public interface AuthenticationService {

    Notification<Boolean> register(String username, String password) throws UnsupportedEncodingException;

    Notification<User> login(String username, String password) throws AuthenticationException;

    boolean logout(User user);

    String findSaltByUsername(String username);

}
