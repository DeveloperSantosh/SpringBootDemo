package com.treeleaf.test_project;

import com.treeleaf.test_project.model.Blog;
import com.treeleaf.test_project.model.Comment;
import com.treeleaf.test_project.model.User;
import com.treeleaf.test_project.model.UserDetails;
import com.treeleaf.test_project.repository.BlogRepository;
import com.treeleaf.test_project.repository.CommentRepository;
import com.treeleaf.test_project.repository.UserDetailsRepository;
import com.treeleaf.test_project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class TestProjectApplicationTests {

	@Test
	void contextLoads() {
	}

}
