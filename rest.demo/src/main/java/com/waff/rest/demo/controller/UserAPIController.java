package com.waff.rest.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waff.rest.demo.model.UserModel;
import com.waff.rest.demo.repository.UserRepository;

@RestController
@RequestMapping("/user_form")
public class UserAPIController {

    private UserRepository userRepository;

    public UserAPIController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{user_type}")
    public List<UserModel> findAllProductsByType(@PathVariable String user_type) {
        List<UserModel> users = userRepository.findByUserType(user_type);
        return users;
    }

    @PostMapping
    public ResponseEntity<UserModel> createProduct(@RequestBody UserModel user_form) {
        user_form = userRepository.save(user_form);
        return ResponseEntity.created(URI.create("http://localhost:8080/user_form")).body(user_form);
    }

}
