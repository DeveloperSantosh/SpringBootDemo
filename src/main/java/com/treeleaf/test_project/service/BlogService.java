package com.treeleaf.test_project.service;

import com.treeleaf.test_project.model.Blog;

import java.util.List;

public interface BlogService {
    public Blog saveBlog(Blog userDetails);
    public Blog updateBlog(Blog userDetails, String blogTitle);
    public void deleteBlogByTitle(String blogTitle);
    public Blog getBlogByTitle(String blogTitle);
    public List<Blog> getAllBlog();
}
