package com.example.studia.services;

import com.example.studia.models.Exercise;
import com.example.studia.models.WorkoutType;
import com.example.studia.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public Exercise addExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(Long id, Exercise exercise) {
        if (exerciseRepository.existsById(id)) {
            exercise.setId(id);
            return exerciseRepository.save(exercise);
        }
        return null; // Handle the case where the exercise with the given id doesn't exist
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    public List<Exercise> getExercisesByWorkoutType(WorkoutType workoutType) {
        return exerciseRepository.findByWorkoutType(workoutType);
    }
}
