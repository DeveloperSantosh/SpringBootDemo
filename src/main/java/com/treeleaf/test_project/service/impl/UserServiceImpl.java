package com.treeleaf.test_project.service.impl;

import com.treeleaf.test_project.exceptions.UserNotFoundException;
import com.treeleaf.test_project.model.User;
import com.treeleaf.test_project.repository.UserRepository;
import com.treeleaf.test_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User userDetails) {
        return userRepository.save(userDetails);
    }

    @Override
    @CachePut(value="User", key="#userId")
    public User updateUser(User userDetails, Integer userId) {
        User oldUser = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
        oldUser.setDetails(userDetails.getDetails());
        oldUser.setSurname(userDetails.getSurname());
        oldUser.setName(userDetails.getName());
        return userRepository.save(oldUser);
    }

    @Override
    @CacheEvict(value = "User", key = "#userId")
    public void deleteUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
        userRepository.delete(user);
    }

    @Override
    @Cacheable(value = "User", key = "#userId")
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
