package com.example.tokenapp.project.modal;

public class Company { //TODO: add image path and to upload image on server
    String name;
    String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company(String name, String website) {
        this.name = name;
        this.website = website;
    }

    @Override
    public String toString() {
        return  name;
    }
}
