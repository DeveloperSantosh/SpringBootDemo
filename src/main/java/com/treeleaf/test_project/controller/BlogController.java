package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.Blog;
import com.treeleaf.test_project.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    List<Blog> all(){
        return blogService.getAllBlog();
    }

    @PostMapping("/blogs")
    Blog addBlog(@RequestBody Blog newBlog){
        return blogService.saveBlog(newBlog);
    }

    @GetMapping("/blogs/{title}")
    Blog getBlog(@PathVariable String title){
        return blogService.getBlogByTitle(title);
    }

    @PutMapping("/blogs/{title}")
    Blog replaceBlog(@RequestBody Blog newBlog, @PathVariable String title) {
        return blogService.updateBlog(newBlog, title);
    }

    @DeleteMapping("/blogs/{title}")
    void deleteBlog(@PathVariable String title) {
        blogService.deleteBlogByTitle(title);
    }
}
