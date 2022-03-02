package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.Comment;
import com.treeleaf.test_project.service.CommentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    List<Comment> all(){
        return commentService.getAllComment();
    }

    @PostMapping("/comments")
    Comment addComment(@RequestBody Comment newComment){
        return commentService.saveComment(newComment);
    }

    @GetMapping("/comments/{id}")
    Comment getComment(@PathVariable int id){
        return commentService.getCommentById(id);
    }

    @PutMapping("/comments/{id}")
    Comment replaceComment(@RequestBody Comment newComment, @PathVariable int id) {
        return commentService.updateComment(newComment, id);
    }

    @DeleteMapping("/comments/{id}")
    void deleteBlog(@PathVariable int id) {
        commentService.deleteCommentById(id);
    }
}
