package com.waff.rest.demo.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.waff.rest.demo.model.UserModel;
import com.waff.rest.demo.repository.UserRepository;

@Service
public class UserService {

    // Initialize - Spricht mit dem UserRepository
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //

    // Methoden

    // GET http://localhost:8080/user_form/user_typ - Alle Accounts vom user_typ
    public List<UserModel> findByUserType(String user_type) {
        return userRepository.findByUserType(user_type);
    }
    //

    // GET http://localhost:8080/user_form/user_typ/id - Account vom user_typ + ID
    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }
    //

    // GET http://localhost:8080/user_form - Alle Accounts in der user_form Database
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }
    //

    // POST http://localhost:8080/user_form - Mit nen JSON einen Account hinzufügen
    public ResponseEntity<UserModel> createProduct(@RequestBody UserModel user_form) {
        user_form = userRepository.save(user_form);
        return ResponseEntity.created(URI.create("http://localhost:8080/user_form")).body(user_form);
    }
    //

    // PUT http://localhost:8080/user_form - Mit nen JSON einen Account updaten,
    // hinzufügen falls null
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel user_form) {
        UserModel existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            existingUser.setName(user_form.getName());
            existingUser.setSurname(user_form.getSurname());
            existingUser.setemail_adress(user_form.getemail_adress());
            existingUser.setpassword(user_form.getpassword());
            existingUser.setuser_type(user_form.getUserType());
            user_form = userRepository.save(existingUser);
            return ResponseEntity.ok(user_form);
        }
    }
    //

    // DELETE http://localhost:8080/user_form/id - Account löschen
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        UserModel existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(existingUser);
        return ResponseEntity.noContent().build();
    }
    //
}
