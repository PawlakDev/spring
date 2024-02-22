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


        System.out.println("*****");
        System.out.println(id);
        System.out.println("*****");

        List<Plan> workouts = planService.getAllPlans();
        List<Plan> workoutsByUserId = new ArrayList<>();

        // adding existing workouts to the plan list
        workouts.forEach(workout -> {
            if(workout.getIdu() == id){
                workoutsByUserId.add(workout);
            }
        });


        model.addAttribute("plans", workoutsByUserId);

        model.addAttribute("name", currentPrincipalName);

        // Pobierz role (GrantedAuthority) z obiektu Authentication
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Utwórz listę dla przechowywania nazw ról
        // W tej liście przechowujemy tylko pierwszą rolę (możesz dostosować to do własnych potrzeb)
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        // Sprawdź, czy istnieją role, a następnie dodaj pierwszą rolę do modelu
        if (!roles.isEmpty()) {
            model.addAttribute("role", roles.get(0));
        } else {
            model.addAttribute("role", "Brak roli");
        }


        return "showPlans";
    }
}
