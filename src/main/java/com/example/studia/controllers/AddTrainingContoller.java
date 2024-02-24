package com.example.studia.controllers;

import com.example.studia.models.AddTrainingModel;
import com.example.studia.models.Workouts;
import com.example.studia.services.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.example.studia.services.UserService;

@Controller
public class AddTrainingContoller {

    @Autowired
    private WorkoutsService workoutService;

    private final UserService userService;

    public AddTrainingContoller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addTraining")
    public String addTraining(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = authentication.getName();

        Long id = userService.findUserIdByUsername(currentPrincipalName);

        List<Workouts> workouts = workoutService.getAllWorkouts();
        List<Workouts> workoutsByUserId = new ArrayList<>();

        workouts.forEach(workout -> {
            if(workout.getIdu() == id){
                workoutsByUserId.add(workout);
            }
        });

        model.addAttribute("workouts", workoutsByUserId);


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


        return "addTraining";
    }

    @RequestMapping(value = "/addTraining", method = RequestMethod.POST)
    public String Training(Model model, @ModelAttribute("addTraining") AddTrainingModel training) {
        System.out.println(training.getTrainingType());
        System.out.println(training.getTrainingDate());
        System.out.println(training.getTrainingDistanse());
        System.out.println(training.getTrainingTime());
        System.out.println(training.getTrainingDescription());

        return "redirect:/";
    }

}
