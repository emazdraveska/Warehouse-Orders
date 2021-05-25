package mk.ukim.finki.bazi.service.impl;

import mk.ukim.finki.bazi.model.User;
import mk.ukim.finki.bazi.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.bazi.model.exceptions.InvalidCredentialsException;
import mk.ukim.finki.bazi.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.bazi.model.exceptions.InvalidUsernameOrPasswordException;
import mk.ukim.finki.bazi.repository.UserRepository;
import mk.ukim.finki.bazi.service.AuthService;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
