package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.exceptions.BlogNotFoundException;
import com.treeleaf.test_project.model.Blog;
import com.treeleaf.test_project.repository.BlogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blogs")
    List<Blog> all(){
        return blogRepository.findAll();
    }

    @PostMapping("/blogs")
    Blog addBlog(@RequestBody Blog newBlog){
        return blogRepository.save(newBlog);
    }

    @GetMapping("/blogs/{title}")
    Blog getBlog(@PathVariable String title){
        return blogRepository.findById(title).orElseThrow(() -> new BlogNotFoundException(title));
    }

    @PutMapping("/blogs/{title}")
    Blog replaceBlog(@RequestBody Blog newBlog, @PathVariable String title) {

        return blogRepository.findById(title)
                .map(blog -> {
                    blog.setTitle(newBlog.getTitle());
                    blog.setContent(newBlog.getContent());
                    return blogRepository.save(blog);
                })
                .orElseGet(() -> {
                    newBlog.setTitle(title);
                    return blogRepository.save(newBlog);
                });
    }

    @DeleteMapping("/blogs/{id}")
    void deleteBlog(@PathVariable String title) {
        blogRepository.deleteById(title);
    }
}
