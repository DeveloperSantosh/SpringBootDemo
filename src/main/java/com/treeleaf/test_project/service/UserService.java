package com.treeleaf.test_project.service;

import com.treeleaf.test_project.model.User;
import java.util.List;

public interface UserService {
    public User saveUser(User userDetails);
    public User updateUser(User userDetails, Integer userId);
    public void deleteUserById(Integer userId);
    public User getUserById(Integer userId);
    public List<User> getAllUser();
}
