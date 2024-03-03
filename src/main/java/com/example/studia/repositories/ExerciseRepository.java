package com.example.studia.repositories;

import com.example.studia.models.ExerciseModel;
import com.example.studia.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseModel, Long> {
}