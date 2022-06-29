package io.benedetto.springboottoheroku.security.payload;

import java.util.Set;

public class SignupRequest {
    private String username;

    private String name;

    private String last_name;

    private String email;

    private String password;

    private Set<String>  roles;

    public SignupRequest() {}
    
    public SignupRequest(String name, String username, String last_name, String email, String password, Set<String>  roles) {
        this.name = name;
        this.username = username;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public Set<String>  getRoles() {
        return roles;
    }

    public void setRoles(Set<String>  roles) {
        this.roles = roles;
    }


    

    
}
