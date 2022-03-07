package com.treeleaf.test_project.repository;

import com.treeleaf.test_project.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

}
