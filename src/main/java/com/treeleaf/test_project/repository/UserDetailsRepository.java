package com.treeleaf.test_project.repository;

import com.treeleaf.test_project.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
}
