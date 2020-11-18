package service.user;

import model.User;
import model.validation.Notification;
import repository.EntityNotFoundException;
import repository.user.AuthenticationException;

public interface UserService {

    User findByUsername(String username) throws EntityNotFoundException, AuthenticationException;

}
