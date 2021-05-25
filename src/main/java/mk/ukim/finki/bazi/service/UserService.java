package mk.ukim.finki.bazi.service;

import mk.ukim.finki.bazi.model.Role;
import mk.ukim.finki.bazi.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, Role role);

}
