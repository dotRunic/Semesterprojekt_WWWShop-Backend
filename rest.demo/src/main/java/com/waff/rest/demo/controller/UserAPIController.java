package com.waff.rest.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // Gibt alles was sich in User_form befindet wieder

    @GetMapping()
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    // zum Durchsuchen von User_types aus dem User_form

    @GetMapping("/{user_type}")
    public List<UserModel> findAllByType(@PathVariable String user_type) {
        List<UserModel> users = userRepository.findByUserType(user_type);
        return users;
    }

    // zum Einfügen von Einträgen aus der User_form Datnebank

    @PostMapping
    public ResponseEntity<UserModel> createProduct(@RequestBody UserModel user_form) {
        user_form = userRepository.save(user_form);
        return ResponseEntity.created(URI.create("http://localhost:8080/user_form")).body(user_form);
    }

    // zum Updaten von Einträgen aus der User_form Datenbank

    @PutMapping("/{id}")
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

    // zum Löschen der Einträge aus der User_form Datenbank

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        UserModel existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(existingUser);
        return ResponseEntity.noContent().build();
    }

}
