package com.example.studia.services;

import com.example.studia.models.ExerciseModel;
import com.example.studia.models.Plan;
import com.example.studia.models.UserEntity;
import com.example.studia.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void addExercise(String name, String description, int duration, long plan_id) {
        ExerciseModel exercise = new ExerciseModel();

        exercise.setName(name);
        exercise.setDescription(description);
        exercise.setDuration(duration);
        exercise.setPlan_id(plan_id);
        exerciseRepository.save(exercise);
    }

}
