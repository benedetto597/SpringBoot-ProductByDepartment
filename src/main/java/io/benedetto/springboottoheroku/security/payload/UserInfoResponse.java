package io.benedetto.springboottoheroku.security.payload;

import java.util.List;


public class UserInfoResponse {
    private String username;

    private String email;

    private int id;

    private List<String> roles;

    public UserInfoResponse() {}

    public UserInfoResponse(int id, String username, String email,  List<String> roles) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    
}
