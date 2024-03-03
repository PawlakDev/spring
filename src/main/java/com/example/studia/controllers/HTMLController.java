package com.example.studia.controllers;

import com.example.studia.models.Workouts;
import com.example.studia.services.UserService;
import com.example.studia.services.WorkoutsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HTMLController {

    private final WorkoutsService workoutService;
    private final UserService userService;

    @GetMapping
    public String index(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = authentication.getName();

        model.addAttribute("name", currentPrincipalName);

        Long id = userService.findUserIdByUsername(currentPrincipalName);

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

        List<Workouts> workouts = workoutService.getAllWorkouts();

        AtomicInteger i= new AtomicInteger();
        workouts.forEach(workout ->{
            if(workout.getIdu() == id) {
                i.getAndIncrement();
            }
        });
            model.addAttribute("workoutsNumber", i);

        return "index";
    }
}
