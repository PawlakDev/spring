package com.example.studia.controllers;

import com.example.studia.models.PlannedWorkout;
import com.example.studia.services.PlannedWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plannedWorkouts")
public class PlannedWorkoutController {

    private final PlannedWorkoutService plannedWorkoutService;

    @Autowired
    public PlannedWorkoutController(PlannedWorkoutService plannedWorkoutService) {
        this.plannedWorkoutService = plannedWorkoutService;
    }

    @GetMapping
    public ResponseEntity<List<PlannedWorkout>> getAllPlannedWorkouts() {
        List<PlannedWorkout> plannedWorkouts = plannedWorkoutService.getAllPlannedWorkouts();
        return new ResponseEntity<>(plannedWorkouts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlannedWorkout> getPlannedWorkoutById(@PathVariable Long id) {
        PlannedWorkout plannedWorkout = plannedWorkoutService.getPlannedWorkoutById(id);
        return new ResponseEntity<>(plannedWorkout, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlannedWorkout> addPlannedWorkout(@RequestBody PlannedWorkout plannedWorkout) {
        PlannedWorkout savedPlannedWorkout = plannedWorkoutService.addPlannedWorkout(plannedWorkout);
        return new ResponseEntity<>(savedPlannedWorkout, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlannedWorkout> updatePlannedWorkout(@PathVariable Long id, @RequestBody PlannedWorkout plannedWorkout) {
        PlannedWorkout updatedPlannedWorkout = plannedWorkoutService.updatePlannedWorkout(id, plannedWorkout);
        return new ResponseEntity<>(updatedPlannedWorkout, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlannedWorkout(@PathVariable Long id) {
        plannedWorkoutService.deletePlannedWorkout(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
