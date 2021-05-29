package com.example.chatings.Model;

public class User {
    private String id;
    private String name;
    private String monileno;
    private String email;
    private String password;
    private String imageURL;

    public User(){}

    public User(String id, String name, String monileno, String email, String password, String imageURL) {
        this.id = id;
        this.name = name;
        this.monileno = monileno;
        this.email = email;
        this.password = password;
        this.imageURL = imageURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getMonileno() {
        return monileno;
    }

    public void setMonileno(String monileno) {
        this.monileno = monileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
