package com.example.testApplication.demo.Services.LoginModule;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load the user from the database (dummy implementation)
        if ("admin".equals(username)) {
            return new User("admin",
                    "$2a$10$W3NULmRROG/8hV3C3sOUIuAC5ZO5k2aqblIsB3Y6Ru2QCRsTHGHGS",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
