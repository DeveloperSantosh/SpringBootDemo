package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.UserDetails;
import com.treeleaf.test_project.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/userDetails")
    public ResponseEntity<List<UserDetails>> getAllUserDetails(){
        return ResponseEntity.ok(userDetailsService.getAllUserDetails());
    }

}
