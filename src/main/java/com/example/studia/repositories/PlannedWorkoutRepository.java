package com.example.studia.repositories;

import com.example.studia.models.PlannedWorkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlannedWorkoutRepository extends JpaRepository<PlannedWorkout, Long> {
    // You can add custom query methods here if needed
}

