package com.example.studia.controllers;

import com.example.studia.models.UserEntity;
import com.example.studia.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserEntity userDto,
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            return "register";
        }

        System.out.println(userDto.getUsername());
        System.out.println(userDto.getPassword());

        userService.createUser(userDto.getFirstName(), userDto.getLastName(), userDto.getUsername(), 1999, userDto.getPassword());


        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String customLogin() {
        return "login";
    }

    @GetMapping("/welcome")
    public String greeting() {
        return "welcome";
    }
}
