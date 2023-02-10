package com.waff.rest.demo.dto;

public class UserRequestDTO {
    
    private String name;

    private String surname;

    private String email_adress;

    private String userType;

    private String password;

    public UserRequestDTO(){
    };

    // CONSTRUCTOR

    public UserRequestDTO(String name, String surname, String email_adress, String userType, String password) {
        this.name = name;
        this.surname = surname;
        this.email_adress = email_adress;
        this.userType = userType;
        this.password = password;
    }


    // GETTER und SETTER

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

    public String getEmail_adress() {
        return this.email_adress;
    }

    public void setEmail_adress(String email_adress) {
        this.email_adress = email_adress;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}