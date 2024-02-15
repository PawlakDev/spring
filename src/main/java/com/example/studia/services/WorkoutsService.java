package com.example.studia.services;

import com.example.studia.models.Workouts;
import com.example.studia.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutsService {
    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workouts> getAllWorkouts() {
        return workoutRepository.findAll();
    }


}
