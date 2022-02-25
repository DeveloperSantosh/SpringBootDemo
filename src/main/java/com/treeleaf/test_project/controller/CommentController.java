package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.Comment;
import com.treeleaf.test_project.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository blogRepository) {
        this.commentRepository = blogRepository;
    }

    @GetMapping("/comments")
    List<Comment> all(){
        return commentRepository.findAll();
    }

    @PostMapping("/comments")
    Comment addComment(@RequestBody Comment newComment){
        return commentRepository.save(newComment);
    }

    @GetMapping("/comments/{id}")
    Comment getComment(@PathVariable int id){
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/comments/{id}")
    Comment replaceComment(@RequestBody Comment newComment, @PathVariable int id) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setComment(newComment.getComment());
                    return commentRepository.save(comment);
                })
                .orElseGet(() -> {
                    newComment.setComment_id(id);
                    return commentRepository.save(newComment);
                });
    }

    @DeleteMapping("/comments/{id}")
    void deleteBlog(@PathVariable int id) {
        commentRepository.deleteById(id);
    }
}
