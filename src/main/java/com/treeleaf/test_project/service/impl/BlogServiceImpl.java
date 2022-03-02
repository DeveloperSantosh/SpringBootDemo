package com.treeleaf.test_project.service.impl;

import com.treeleaf.test_project.exceptions.BlogNotFoundException;
import com.treeleaf.test_project.model.Blog;
import com.treeleaf.test_project.model.Comment;
import com.treeleaf.test_project.model.User;
import com.treeleaf.test_project.repository.BlogRepository;
import com.treeleaf.test_project.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog, String blogTitle) {
        Blog oldBlog = blogRepository.findById(blogTitle).orElseThrow(()-> new BlogNotFoundException(blogTitle));
        oldBlog.setComments(blog.getComments());
        oldBlog.setAuthor(blog.getAuthor());
        oldBlog.setContent(blog.getContent());
        oldBlog.setTitle(blog.getTitle());
        return blogRepository.save(oldBlog);
    }

    @Override
    public String deleteBlogByTitle(String blogTitle) {
        Blog blog;
        try {
            blog = blogRepository.findById(blogTitle).orElseThrow(() -> new BlogNotFoundException(blogTitle));
        }catch (BlogNotFoundException ignored){
            return "Blog Not Found";
        }
        blogRepository.delete(blog);
        return "Blog deleted Successfully";
    }

    @Override
    public Blog getBlogByTitle(String blogTitle) {
        return blogRepository.findById(blogTitle).orElseThrow(()-> new BlogNotFoundException(blogTitle));
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public String addComment(String title, Comment comment) {
        Blog blog;
        try {
            blog = blogRepository.findById(title).orElseThrow(()-> new BlogNotFoundException(title));
        }catch (BlogNotFoundException ignored){
            return "Sorry Blog not found with Title "+title;
        }
        if(blog.getComments().contains(comment))
            return "Comment Already Exists";
        blog.addComment(comment);
        blogRepository.save(blog);
        return "Comment added Successfully";
    }

    @Override
    public String changeAuthor(String title, User author) {
        Blog blog;
        try {
            blog = blogRepository.findById(title).orElseThrow(()->new BlogNotFoundException(title));
        }catch (BlogNotFoundException ignored){
            return "Blog not found with Title "+title;
        }
        blog.setAuthor(author);
        return "Blog Author changed Successfully to "+author.toString();
    }
}
