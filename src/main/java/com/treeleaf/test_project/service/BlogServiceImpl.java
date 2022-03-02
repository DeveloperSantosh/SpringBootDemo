package com.treeleaf.test_project.service;

import com.treeleaf.test_project.exceptions.BlogNotFoundException;
import com.treeleaf.test_project.model.Blog;
import com.treeleaf.test_project.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog userDetails) {
        return null;
    }

    @Override
    @CachePut(value = "Blog",key = "#blogTitle")
    public Blog updateBlog(Blog blog, String blogTitle) {
        Blog oldBlog = blogRepository.findById(blogTitle).orElseThrow(()-> new BlogNotFoundException(blogTitle));
        oldBlog.setComments(blog.getComments());
        oldBlog.setAuthor(blog.getAuthor());
        oldBlog.setCreatedAt(blog.getCreatedAt());
        oldBlog.setContent(blog.getContent());
        return blogRepository.save(oldBlog);
    }

    @Override
    @CacheEvict(value = "Blog", key = "#blogTitle")
    public void deleteBlogByTitle(String blogTitle) {
        Blog blog = blogRepository.findById(blogTitle).orElseThrow(()-> new BlogNotFoundException(blogTitle));
        blogRepository.delete(blog);
    }

    @Override
    @Cacheable(value = "Blog", key = "#blogTitle")
    public Blog getBlogByTitle(String blogTitle) {
        return blogRepository.findById(blogTitle).orElseThrow(()-> new BlogNotFoundException(blogTitle));
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }
}
