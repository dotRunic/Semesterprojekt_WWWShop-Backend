package com.waff.rest.demo.controller;

import java.util.List;
import java.util.Optional;

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
import com.waff.rest.demo.service.UserService;

@RestController
@RequestMapping("/user_form")
public class UserAPIController {

    // Initialize - spricht mit dem UserService
    private UserService userService;

    public UserAPIController(UserService userService) {
        this.userService = userService;
    }

    // MAPPINGS, GET, POST, PUT, DELTE

    // Gibt alles was sich in User_form befindet wieder
    @GetMapping()
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }
    //

    // Durchsucht alle User aus dem User_form, und filtert diese nach user_type
    @GetMapping("/{user_type}")
    public List<UserModel> findAllByType(@PathVariable String user_type) {
        return userService.findByUserType(user_type);
    }
    //

    // Durchsucht alle User aus dem User_form, und filtert diese nach ID
    @GetMapping("/{user_type}/{id}")
    public Optional<UserModel> findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    //

    // zum Updaten von Usern in die der User_form Datenbank durch ID
    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel user_form) {
        return userService.updateUser(id, user_form);
    }
    //

    // zum Einfügen von Usern in die User_form Datenbank
    @PostMapping
    public ResponseEntity<UserModel> createProduct(@RequestBody UserModel user_form) {
        return userService.createProduct(user_form);
    }
    //

    // zum Löschen der Einträge aus der User_form Datenbank
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
    //
}
