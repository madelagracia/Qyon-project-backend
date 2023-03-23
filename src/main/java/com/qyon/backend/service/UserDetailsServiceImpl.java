package com.qyon.backend.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.qyon.backend.data.UserDetailsData;
import com.qyon.backend.model.UserModel;
import com.qyon.backend.repository.UserRepository;
import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userData = repository.findByLogin(username);
        if (userData.isEmpty()) {
            throw new UsernameNotFoundException("User [" + username + "] not found");
        }

        return new UserDetailsData(userData);
    }

    
}
