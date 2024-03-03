package com.example.studia.controllers;

import com.example.studia.models.Plan;
import com.example.studia.models.UserEntity;
import com.example.studia.services.PlanService;
import com.example.studia.services.UserService;
import com.example.studia.services.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AddPlanController
{
    @Autowired
    private WorkoutsService workoutService;

    private final UserService userService;

    private final PlanService planService;


    public AddPlanController(UserService userService, PlanService planService) {
        this.userService = userService;
        this.planService = planService;
    }

    @GetMapping("/addPlan")
    public String customLogin(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = authentication.getName();

        Long id = userService.findUserIdByUsername(currentPrincipalName);

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

        return "addPlan";
    }
    @RequestMapping(value = "/addPlan", method = RequestMethod.POST)
    public String addPlan(@ModelAttribute("addPlan") Plan addPlan) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = authentication.getName();

        UserEntity user = userService.findUserByUsername(currentPrincipalName);
        planService.addPlan(addPlan.getName(), user);
        return "redirect:/addPlan"; // Tutaj podaj odpowiednią ścieżkę URL
    }
}
