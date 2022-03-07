package com.treeleaf.test_project.service.impl;

import com.treeleaf.test_project.model.UserRole;
import com.treeleaf.test_project.repository.UserRoleRepository;
import com.treeleaf.test_project.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole updateUserRole(UserRole userRole, String user_role) {
        UserRole oldUserRole = userRoleRepository.findById(user_role).get();
        oldUserRole.setRole_type(userRole.getRole_type());
        oldUserRole.setDescription(userRole.getDescription());
        return userRoleRepository.save(oldUserRole);
    }

    @Override
    public String deleteUserRoleByRole(String user_role) {
        Optional<UserRole> userRole = userRoleRepository.findById(user_role);
        if(userRole.isPresent()){
            userRoleRepository.delete(userRole.get());
            return "User Deleted Successfully";
        }
        return "User Role not Found with Title: "+user_role;
    }

    @Override
    public UserRole getUserRoleByRole(String user_role) {
        Optional<UserRole> userRole = userRoleRepository.findById(user_role);
        return userRole.orElse(null);
    }

    @Override
    public List<UserRole> getAllUserRole() {
        return userRoleRepository.findAll();
    }
}
