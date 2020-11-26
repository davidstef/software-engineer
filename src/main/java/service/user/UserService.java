package service.user;

import model.User;
import service.validation.Notification;
import repository.EntityNotFoundException;
import repository.user.AuthenticationException;

import java.io.UnsupportedEncodingException;

public interface UserService {

    User findByUsername(String username) throws EntityNotFoundException, AuthenticationException;

    Notification<Boolean> save(String username, String password) throws UnsupportedEncodingException;

    User findById(Long id) throws EntityNotFoundException;

    String findSaltByUsername(String username);

    Notification<Boolean> update(String username, String password, Long id);

    boolean remove(Long id) throws EntityNotFoundException;

}
