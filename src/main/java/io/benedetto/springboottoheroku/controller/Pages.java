package io.benedetto.springboottoheroku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller()
public class Pages {
    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/register") 
    public String register() {
        return "register";
    }

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
