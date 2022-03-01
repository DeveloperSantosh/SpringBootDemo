package com.treeleaf.test_project.repository;

import com.treeleaf.test_project.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, String> {
}
