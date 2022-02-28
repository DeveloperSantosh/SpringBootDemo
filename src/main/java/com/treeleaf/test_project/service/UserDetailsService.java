package com.treeleaf.test_project.service;

import com.treeleaf.test_project.model.UserDetails;

import java.util.List;

public interface UserDetailsService {

    public UserDetails saveUserDetails(UserDetails userDetails);
    public UserDetails updateUserDetails(UserDetails userDetails, Integer userDetailsId);
    public void deleteUserDetails(Integer userDetailsId);
    public UserDetails getUserDetailsById(Integer userDetailsId);
    public List<UserDetails> getAllUserDetails();
}
