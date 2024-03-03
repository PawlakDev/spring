package com.example.studia.controllers;

import com.example.studia.models.Plan;
import com.example.studia.services.PlanService;
import com.example.studia.services.UserService;
import com.example.studia.services.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanController {
    @Autowired
    private PlanService planService;

    private final UserService userService;

    public PlanController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/showPlans")
    public String getAllPlans(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);

        Long id = userService.findUserIdByUsername(currentPrincipalName);


        model.addAttribute("name", currentPrincipalName);

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if (!roles.isEmpty()) {
            model.addAttribute("role", roles.get(0));
        } else {
            model.addAttribute("role", "Brak roli");
        }


        List<Plan> plans = planService.getAllPlans();
        model.addAttribute("plans", plans);

        return "showPlans";
    }
}
