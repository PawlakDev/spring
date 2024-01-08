package com.example.studia.services;

import com.example.studia.models.PlannedWorkout;
import com.example.studia.repositories.PlannedWorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlannedWorkoutService {

    private final PlannedWorkoutRepository plannedWorkoutRepository;

    @Autowired
    public PlannedWorkoutService(PlannedWorkoutRepository plannedWorkoutRepository) {
        this.plannedWorkoutRepository = plannedWorkoutRepository;
    }

    public List<PlannedWorkout> getAllPlannedWorkouts() {
        return plannedWorkoutRepository.findAll();
    }

    public PlannedWorkout getPlannedWorkoutById(Long id) {
        return plannedWorkoutRepository.findById(id).orElse(null);
    }

    public PlannedWorkout addPlannedWorkout(PlannedWorkout plannedWorkout) {
        return plannedWorkoutRepository.save(plannedWorkout);
    }

    public PlannedWorkout updatePlannedWorkout(Long id, PlannedWorkout plannedWorkout) {
        if (plannedWorkoutRepository.existsById(id)) {
            plannedWorkout.setId(id);
            return plannedWorkoutRepository.save(plannedWorkout);
        }
        return null; // Handle the case where the planned workout with the given id doesn't exist
    }

    public void deletePlannedWorkout(Long id) {
        plannedWorkoutRepository.deleteById(id);
    }
}

