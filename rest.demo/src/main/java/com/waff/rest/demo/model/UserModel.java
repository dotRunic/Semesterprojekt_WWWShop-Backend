package com.waff.rest.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity(name = "user_form")
public class UserModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email_adress")
    private String email_adress;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "password")
    private String password;

    public UserModel(Long id, String name, String surname, String email_adress, String userType, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email_adress = email_adress;
        this.userType = userType;
        this.password = password;
    }

    
    public UserModel() {
    }

    // Getter und Setter vom UserModel

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
