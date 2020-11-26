package repository.user;

import model.User;
import service.validation.Notification;
import repository.EntityNotFoundException;

import java.util.List;

/**
 * Created by Alex on 11/03/2017.
 */
public interface UserRepository {

    List<User> findAll();

    Notification<User> findByUsernameAndPassword(String username, String password) throws AuthenticationException;

    User findByUsername(String username) throws AuthenticationException;

    User findById(Long id);

    boolean update(User user, String stringSalt, Long id);

    boolean save(User user, String stringSalt);

    boolean remove(Long id) throws EntityNotFoundException;

    void removeAll();

    String findSaltByUsername(String username) throws AuthenticationException;

}
