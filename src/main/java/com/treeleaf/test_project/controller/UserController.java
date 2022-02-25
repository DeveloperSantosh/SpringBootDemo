package com.treeleaf.test_project.controller;

import com.treeleaf.test_project.model.User;
import com.treeleaf.test_project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<User> all(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User addUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User getUser(@PathVariable int user_id){
        return userRepository.findById(user_id).orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable int user_id) {

        return userRepository.findById(user_id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setSurname(newUser.getSurname());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setUser_id(user_id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int user_id) {
        userRepository.deleteById(user_id);
    }
}
