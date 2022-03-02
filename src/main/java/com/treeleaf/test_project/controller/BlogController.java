package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.Blog;
import com.treeleaf.test_project.model.Comment;
import com.treeleaf.test_project.model.User;
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
    String deleteBlog(@PathVariable String title) {
        return blogService.deleteBlogByTitle(title);
    }

    @PutMapping("blogs/addComment/{title}")
    String addComment(@PathVariable String title, @RequestBody Comment comment){
        return blogService.addComment(title, comment);
    }

    @PutMapping("blogs/updateAuthor/{title}")
    String updateAuthor(@PathVariable String title, @RequestBody User author){
        return blogService.changeAuthor(title, author);
    }
}
