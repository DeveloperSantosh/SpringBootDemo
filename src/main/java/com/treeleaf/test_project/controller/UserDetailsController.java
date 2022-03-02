package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.UserDetails;
import com.treeleaf.test_project.repository.UserDetailsRepository;
import com.treeleaf.test_project.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/userDetails")
    public List<UserDetails> getAllUserDetails(){
        System.out.println("From Controller");
        return userDetailsService.getAllUserDetails();
    }

    @PostMapping("/userDetails")
    public void saveUserDetails(@RequestBody UserDetails userDetails){
        userDetailsService.saveUserDetails(userDetails);
    }

    @GetMapping("/userDetails/{id}")
    public UserDetails getUserDetailsById(@PathVariable Integer id){
        return userDetailsService.getUserDetailsById(id);
    }

    @PutMapping("/userDetails/{id}")
    public UserDetails updateUserDetails(@RequestBody UserDetails userDetails, @PathVariable Integer id){
        return userDetailsService.updateUserDetails(userDetails, id);
    }

    @DeleteMapping("/userDetails/{id}")
    public void deleteUserDetails(@PathVariable Integer id){
        userDetailsService.deleteUserDetails(id);
    }

}
