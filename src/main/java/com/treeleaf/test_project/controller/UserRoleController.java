package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.UserRole;
import com.treeleaf.test_project.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/userRoles")
    @PreAuthorize("hasRole('Admin')")
    List<UserRole> all(){
        return userRoleService.getAllUserRole();
    }

    @PostMapping("/userRoles/add")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> addUserRole(@RequestBody UserRole user) throws Exception {
        return ResponseEntity.ok(userRoleService.saveUserRole(user));
    }

    @GetMapping("/userRoles/{role_type}")
    @PreAuthorize("hasRole('Admin')")
    UserRole getUserRole(@PathVariable String role_type){
        return userRoleService.getUserRoleByRole(role_type);
    }

    @PutMapping("/users/{role_type}")
    @PreAuthorize("hasRole('Admin')")
    UserRole replaceUserRole(@RequestBody UserRole newUserRole, @PathVariable String role_type) {
        return userRoleService.updateUserRole(newUserRole, role_type);
    }

    @DeleteMapping("/users/{role_type}")
    @PreAuthorize("hasRole('Admin')")
    String deleteUserRole(@PathVariable String role_type) {
        return userRoleService.deleteUserRoleByRole(role_type);
    }

}
