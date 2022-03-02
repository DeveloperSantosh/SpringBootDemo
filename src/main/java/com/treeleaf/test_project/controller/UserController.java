package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.User;
import com.treeleaf.test_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> all(){
        return userService.getAllUser();
    }

    @PostMapping("/users")
    User addUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }

    @GetMapping("/users/{user_id}")
    User getUser(@PathVariable int user_id){
        return userService.getUserById(user_id);
    }

    @PutMapping("/users/{user_id}")
    User replaceUser(@RequestBody User newUser, @PathVariable int user_id) {
        return userService.updateUser(newUser, user_id);
    }

    @DeleteMapping("/users/{user_id}")
    void deleteUser(@PathVariable int user_id) {
        userService.deleteUserById(user_id);
    }
}
