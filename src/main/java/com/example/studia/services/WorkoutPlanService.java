package com.example.studia.services;

import com.example.studia.models.UserEntity;
import com.example.studia.models.WorkoutPlan;
import com.example.studia.repositories.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutPlanService {

    private final WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    public WorkoutPlanService(WorkoutPlanRepository workoutPlanRepository) {
        this.workoutPlanRepository = workoutPlanRepository;
    }

    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }

    public List<WorkoutPlan> getWorkoutPlansByUser(UserEntity user) {
        return workoutPlanRepository.findByUser(user);
    }

    public WorkoutPlan getWorkoutPlanByIdAndUser(Long id, UserEntity user) {
        return workoutPlanRepository.findByIdAndUser(id, user);
    }

    public WorkoutPlan addWorkoutPlan(WorkoutPlan workoutPlan) {
        // You can set the user for the workout plan here if needed
        return workoutPlanRepository.save(workoutPlan);
    }

    public WorkoutPlan updateWorkoutPlan(Long id, WorkoutPlan workoutPlan) {
        Optional<WorkoutPlan> existingWorkoutPlanOptional = workoutPlanRepository.findById(id);

        if (existingWorkoutPlanOptional.isPresent()) {
            WorkoutPlan existingWorkoutPlan = existingWorkoutPlanOptional.get();

            // Check if the existing workout plan belongs to the current user
            if (existingWorkoutPlan.getUser().equals(workoutPlan.getUser())) {
                workoutPlan.setId(id);
                return workoutPlanRepository.save(workoutPlan);
            } else {
                // Throw an exception or handle the case where the workout plan doesn't belong to the current user
                throw new IllegalStateException("Unauthorized to update this workout plan");
            }
        } else {
            // Handle the case where the workout plan with the given id doesn't exist
            return null;
        }
    }

    public void deleteWorkoutPlan(Long id) {
        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findById(id);

        workoutPlanOptional.ifPresent(workoutPlan -> {
            // Check if the workout plan belongs to the current user
            if (workoutPlan.getUser() != null && workoutPlan.getUser().getUsername().equals(getCurrentUsername())) {
                workoutPlanRepository.deleteById(id);
            } else {
                // Throw an exception or handle the case where the workout plan doesn't belong to the current user
                throw new IllegalStateException("Unauthorized to delete this workout plan");
            }
        });
    }

    // Helper method to get the current username from the SecurityContext
    private String getCurrentUsername() {
        return ("Getting current username");
        // Implementation depends on your authentication mechanism
        // Here, we assume Spring Security is being used
        // You might need to adjust this based on your specific authentication setup
        // Alternatively, you can pass the current user's username as a method parameter
        // when calling service methods
        // ...
    }
}
