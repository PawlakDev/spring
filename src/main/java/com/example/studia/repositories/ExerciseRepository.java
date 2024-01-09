package com.example.studia.repositories;

import com.example.studia.models.Exercise;
import com.example.studia.models.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByWorkoutType(WorkoutType workoutType);
    // You can add custom query methods if needed
}
