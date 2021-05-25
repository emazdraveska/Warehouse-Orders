package mk.ukim.finki.bazi.service.impl;

import mk.ukim.finki.bazi.model.Role;
import mk.ukim.finki.bazi.model.User;
import mk.ukim.finki.bazi.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.bazi.model.exceptions.UsernameExistsException;
import mk.ukim.finki.bazi.repository.UserRepository;
import mk.ukim.finki.bazi.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(String username, String password, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }

        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameExistsException(username);

        User user = new User(username,passwordEncoder.encode(password), role);
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s)
                .orElseThrow(()-> new UsernameNotFoundException(s));
    }
}
