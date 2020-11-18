package service.user;

import model.User;
import model.validation.Notification;
import repository.EntityNotFoundException;
import repository.user.AuthenticationException;
import repository.user.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) throws EntityNotFoundException, AuthenticationException {
        return userRepository.findByUsername(username);
    }
}
