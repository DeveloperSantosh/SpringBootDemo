package com.treeleaf.test_project.repository;

import com.treeleaf.test_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
