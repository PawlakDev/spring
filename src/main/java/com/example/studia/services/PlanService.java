package com.example.studia.services;

import com.example.studia.models.Plan;
import com.example.studia.models.Workouts;
import com.example.studia.repositories.PlanRepository;
import com.example.studia.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }
}
