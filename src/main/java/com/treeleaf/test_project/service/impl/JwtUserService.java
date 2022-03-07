package com.treeleaf.test_project.service.impl;

import com.treeleaf.test_project.model.User;
import com.treeleaf.test_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JwtUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                getAuthorities(user));
    }

    public User save(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setUser_id(user.getUser_id());
        newUser.setDetails(user.getDetails());
        return userRepository.save(newUser);
    }

    private Set<SimpleGrantedAuthority> getAuthorities(User user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role->{
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole_type()));
        });
        return authorities;
    }
}
