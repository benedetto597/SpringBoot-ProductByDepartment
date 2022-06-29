package io.benedetto.springboottoheroku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/api/auth")
public class AuthPages {

    @GetMapping("/categories") 
    public String categories() {
        return "categories";
    }

    @GetMapping("/users") 
    public String users() {
        return "users";
    }

    @GetMapping("/products") 
    public String products() {
        return "products";
    }
}
