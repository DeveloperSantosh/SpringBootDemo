package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.UserDetails;
import com.treeleaf.test_project.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/userDetails")
    @PreAuthorize("hasRole('User')")
    public List<UserDetails> getAllUserDetails(){
        return userDetailsService.getAllUserDetails();
    }

    @PostMapping("/userDetails")
    @PreAuthorize("hasRole('User')")
    public void saveUserDetails(@RequestBody UserDetails userDetails){
        userDetailsService.saveUserDetails(userDetails);
    }

    @GetMapping("/userDetails/{id}")
    @PreAuthorize("hasRole('User')")
    public UserDetails getUserDetailsById(@PathVariable Integer id){
        return userDetailsService.getUserDetailsById(id);
    }

    @PutMapping("/userDetails/{id}")
    @PreAuthorize("hasRole('User')")
    public UserDetails updateUserDetails(@RequestBody UserDetails userDetails, @PathVariable Integer id){
        return userDetailsService.updateUserDetails(userDetails, id);
    }

    @DeleteMapping("/userDetails/{id}")
    @PreAuthorize("hasRole('User')")
    public void deleteUserDetails(@PathVariable Integer id){
        userDetailsService.deleteUserDetailsById(id);
    }

}
