package com.example.studia.repositories;

import com.example.studia.models.User;
import com.example.studia.models.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {

    List<WorkoutPlan> findByUser(User user);

    WorkoutPlan findByIdAndUser(Long id, User user);

    // You can add more query methods as needed

}