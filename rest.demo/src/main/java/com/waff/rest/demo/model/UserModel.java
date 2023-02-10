package com.waff.rest.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Column;

@Entity(name = "user_form")
public class UserModel {

    @Positive
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min=2, max=64)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(min=2, max=64)
    @Column(name = "surname")
    private String surname;

    @NotBlank
    @Email
    @Column(name = "email_adress")
    private String email_adress;

    @NotBlank
    @Size(min=2, max=64)
    @Column(name = "user_type")
    private String userType;

    @NotBlank
    @Size(min=2, max=64)
    @Column(name = "password")
    private String password;

    // CONSTRUCTOR
    public UserModel(Long id, String name, String surname, String email_adress, String userType, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email_adress = email_adress;
        this.userType = userType;
        this.password = password;
    }
    // 
    
    // EMPTY CONSTRUCTOR - zum initializen von Objekten mit default values
    public UserModel() {
    }

    // GETTER und SETTER vom UserModel

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getemail_adress() {
        return this.email_adress;
    }

    public void setemail_adress(String email_adress) {
        this.email_adress = email_adress;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setuser_type(String usertype) {
        this.userType = usertype;
    }

    public String getpassword(){
        return this.password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

}
