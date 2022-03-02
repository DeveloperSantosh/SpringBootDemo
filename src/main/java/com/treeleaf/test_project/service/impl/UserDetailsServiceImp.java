package com.treeleaf.test_project.service.impl;

import com.treeleaf.test_project.exceptions.UserDetailsNotFoundException;
import com.treeleaf.test_project.model.UserDetails;
import com.treeleaf.test_project.repository.UserDetailsRepository;
import com.treeleaf.test_project.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserDetailsServiceImp(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Override
    @CachePut(value="UserDetails", key="#userDetailsId")
    public UserDetails updateUserDetails(UserDetails userDetails, Integer userDetailsId) {
        UserDetails userDetails1 = userDetailsRepository.findById(userDetailsId).
                orElseThrow(()-> new UserDetailsNotFoundException(userDetailsId));
        userDetails1.setLocation(userDetails.getLocation());
        userDetails1.setNumber(userDetails.getNumber());
        return userDetailsRepository.save(userDetails1);
    }

    @Override
    @CacheEvict(value = "UserDetails", key = "#userDetailsId")
    public void deleteUserDetailsById(Integer userDetailsId) {
        UserDetails userDetails = userDetailsRepository.findById(userDetailsId).
                orElseThrow(()-> new UserDetailsNotFoundException(userDetailsId));
        userDetailsRepository.delete(userDetails);
    }

    @Override
    @Cacheable(value = "UserDetails", key = "#userDetailsId")
    public UserDetails getUserDetailsById(Integer userDetailsId) {
        return userDetailsRepository.findById(userDetailsId).
                orElseThrow(()-> new UserDetailsNotFoundException(userDetailsId));
    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        return userDetailsRepository.findAll();
    }
}
