package com.example.lilylane.couriers.security;

import com.example.lilylane.couriers.model.Users;
import com.example.lilylane.couriers.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * used to load user details from database, when authentication is performed by Spring Security.
 */
@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    /**
     * used to retrieve user details based on the provided username.
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Users registeredUser = userService.findUserByUsername(username);
            return new User(registeredUser.getUsername(), registeredUser.getPassword(), Collections.emptyList());
        } catch (Exception ex) {
            log.error("Request format error", ex);
            throw new UsernameNotFoundException("Request format Error");
        }
    }

}
