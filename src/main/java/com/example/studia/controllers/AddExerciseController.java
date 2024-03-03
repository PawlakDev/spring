package com.example.studia.controllers;

import com.example.studia.models.ExerciseModel;
import com.example.studia.models.Plan;
import com.example.studia.models.UserEntity;
import com.example.studia.services.ExerciseService;
import com.example.studia.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AddExerciseController {

    private final UserService userService;
    private final ExerciseService exerciseService;

    public AddExerciseController(UserService userService, ExerciseService exerciseService) {
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/addExercise")
    public String addExercise(Model model) {
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


        return "addExercise";
    }

    @RequestMapping(value = "/addExercise", method = RequestMethod.POST)
    public String addPlan(@ModelAttribute("addExercise") ExerciseModel exercise) {

        exerciseService.addExercise(exercise.getName(), exercise.getDescription(), exercise.getDuration(), exercise.getPlan_id());

        System.out.println(exercise.getName());
        System.out.println(exercise.getDescription());
        System.out.println(exercise.getDuration());
        System.out.println(exercise.getPlan_id());
        return "redirect:/addExercise";
    }
}
