package com.example.tokenapp.project.modal;

public class User { //TODO: update modal for further use
    String name;
    String email;
    int phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public User(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
