package com.example.studia.controllers;

import com.example.studia.models.User;
import com.example.studia.models.WorkoutPlan;
import com.example.studia.services.UserService;
import com.example.studia.services.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutPlans")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;
    private final UserService userService;

    @Autowired
    public WorkoutPlanController(WorkoutPlanService workoutPlanService, UserService userService) {
        this.workoutPlanService = workoutPlanService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlansForLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User currentUser = userService.getUserByUsername(currentUsername);
        List<WorkoutPlan> workoutPlans = workoutPlanService.getWorkoutPlansByUser(currentUser);

        return new ResponseEntity<>(workoutPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutPlan> getWorkoutPlanById(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        User currentUser = userService.getUserByUsername(currentUsername);
        WorkoutPlan workoutPlan = workoutPlanService.getWorkoutPlanByIdAndUser(id, currentUser);

        if (workoutPlan != null) {
            return new ResponseEntity<>(workoutPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<WorkoutPlan> addWorkoutPlan(@RequestBody WorkoutPlan workoutPlan) {
        WorkoutPlan savedWorkoutPlan = workoutPlanService.addWorkoutPlan(workoutPlan);
        return new ResponseEntity<>(savedWorkoutPlan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutPlan> updateWorkoutPlan(@PathVariable Long id, @RequestBody WorkoutPlan workoutPlan) {
        WorkoutPlan updatedWorkoutPlan = workoutPlanService.updateWorkoutPlan(id, workoutPlan);
        return new ResponseEntity<>(updatedWorkoutPlan, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable Long id) {
        workoutPlanService.deleteWorkoutPlan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

