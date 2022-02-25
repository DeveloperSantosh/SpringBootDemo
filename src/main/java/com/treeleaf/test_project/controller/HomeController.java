package com.treeleaf.test_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    String home(){
        return "Welcome to My First Spring Project.";
    }
}
