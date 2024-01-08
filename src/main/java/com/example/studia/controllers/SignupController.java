package com.example.studia.controllers;

import com.example.studia.models.User;
import com.example.studia.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup"; // Create a corresponding signup.html template
    }

    @PostMapping("/signup")
    public String processSignupForm(User user) {
        userService.save(user);
        return "redirect:/login";
    }
}
