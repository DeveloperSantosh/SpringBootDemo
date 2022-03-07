package com.treeleaf.test_project.service;

import com.treeleaf.test_project.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserRoleService {
    UserRole saveUserRole(UserRole userRole);
    UserRole updateUserRole(UserRole userRole, String user_role);
    String deleteUserRoleByRole(String user_role);
    UserRole getUserRoleByRole(String user_role);
    List<UserRole> getAllUserRole();
}
