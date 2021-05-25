package mk.ukim.finki.bazi.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_WAREHOUSE,
    ROLE_STORE,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}