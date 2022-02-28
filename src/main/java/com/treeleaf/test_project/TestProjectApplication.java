package com.treeleaf.test_project;

import com.treeleaf.test_project.model.Blog;
import com.treeleaf.test_project.model.Comment;
import com.treeleaf.test_project.model.User;
import com.treeleaf.test_project.model.UserDetails;
import com.treeleaf.test_project.repository.BlogRepository;
import com.treeleaf.test_project.repository.CommentRepository;
import com.treeleaf.test_project.repository.UserDetailsRepository;
import com.treeleaf.test_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableCaching
public class TestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}


}
