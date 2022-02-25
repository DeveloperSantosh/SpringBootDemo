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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TestProjectApplication {

	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}

	public void initializeData(){
		blogRepository.deleteAllInBatch();
		commentRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();

		User user = new User(1, "Santosh", "Mahato");
		UserDetails userDetails= new UserDetails(1, "Gatthaghar, Bhaktapur","9808898892");
		user.setDetails(userDetails);
		userDetailsRepository.save(userDetails);
		userRepository.save(user);

		Blog blog = new Blog("My First Blog","Content of my first blog");
		Comment c1 = new Comment(1, "Good");
		Comment c2 = new Comment(1, "Nice");
		Comment c3 = new Comment(1, "Work-ful");
		Set<Comment> comments = new HashSet<>();
		comments.add(c1);
		comments.add(c2);
		comments.add(c3);
		blog.setComments(comments);
		blog.setAuthor(user);
		blogRepository.save(blog);

		Blog newBlog = new Blog("My Second Blog", "Content of my first blog");
		Set<Comment> comments1 = new HashSet<>();
		comments1.add(c2);
		comments1.add(c3);
		newBlog.setComments(comments1);
		blogRepository.save(newBlog);
	}
}
