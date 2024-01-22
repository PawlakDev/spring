package com.example.studia.controllers;

import com.example.studia.models.UserEntity;
import com.example.studia.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {
    private final UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);

        return "register";
    }


    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserEntity userDto,
                               BindingResult result,
                               Model model){

        userService.createUser(userDto.getFirstName(), userDto.getLastName(), userDto.getPassword(), userDto.getBirthYear());

        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String customLogin() {
        return "login"; //
    }

    @GetMapping("/welcome")
    public String greeting() {
        return "welcome";
    }
}
