package com.treeleaf.test_project.repository;

import com.treeleaf.test_project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
