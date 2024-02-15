package com.example.studia.repositories;
import com.example.studia.models.UserEntity;
import com.example.studia.models.WorkoutPlan;
import com.example.studia.models.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workouts, Long> {
}
