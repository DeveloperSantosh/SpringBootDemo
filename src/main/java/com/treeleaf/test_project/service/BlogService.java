package com.treeleaf.test_project.service;

import com.treeleaf.test_project.model.Blog;
import com.treeleaf.test_project.model.Comment;
import com.treeleaf.test_project.model.User;

import java.util.List;

public interface BlogService {
    public Blog saveBlog(Blog userDetails);
    public Blog updateBlog(Blog userDetails, String blogTitle);
    public String deleteBlogByTitle(String blogTitle);
    public Blog getBlogByTitle(String blogTitle);
    public List<Blog> getAllBlog();
    String addComment(String title, Comment comment);
    String changeAuthor(String title, User author);
}
