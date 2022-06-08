package com.works.domain;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String Phone;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() { return Phone; }

    public void setPhone(String phone) { Phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
