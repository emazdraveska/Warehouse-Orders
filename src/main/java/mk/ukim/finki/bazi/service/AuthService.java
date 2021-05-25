package mk.ukim.finki.bazi.service;

import mk.ukim.finki.bazi.model.User;

public interface AuthService {
    User login(String username, String password);
}
