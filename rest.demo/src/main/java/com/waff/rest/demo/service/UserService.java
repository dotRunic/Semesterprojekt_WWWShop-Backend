package com.waff.rest.demo.service;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.waff.rest.demo.model.UserModel;
import com.waff.rest.demo.repository.UserRepository;


@Service
public class UserService {
    
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findByUserType(String user_type){
        return userRepository.findByUserType(user_type);
    }
    
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<UserModel> createProduct(@RequestBody UserModel user_form) {
        user_form = userRepository.save(user_form);
        return ResponseEntity.created(URI.create("http://localhost:8080/user_form")).body(user_form);
    }

    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel user_form) {
        UserModel existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        existingUser.setName(user_form.getName());
        existingUser.setSurname(user_form.getSurname());
        existingUser.setemail_adress(user_form.getemail_adress());
        existingUser.setpassword(user_form.getpassword());
        existingUser.setuser_type(user_form.getUserType());
        user_form = userRepository.save(existingUser);
        return ResponseEntity.ok(user_form);
    }

    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        UserModel existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(existingUser);
        return ResponseEntity.noContent().build();
    }


}
