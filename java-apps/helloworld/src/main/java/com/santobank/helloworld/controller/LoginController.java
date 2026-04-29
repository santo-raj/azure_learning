package com.santobank.helloworld.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private boolean loggedIn = false;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if ("admin".equals(username) && "admin".equals(password)) {
            loggedIn = true;
            return "SUCCESS";
        }
        return "FAIL";
    }

    @GetMapping("/status")
    public boolean status() {
        return loggedIn;
    }
}