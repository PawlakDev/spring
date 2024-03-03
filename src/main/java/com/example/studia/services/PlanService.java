package com.example.studia.services;

import com.example.studia.models.Plan;
import com.example.studia.models.UserEntity;
import com.example.studia.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }



    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public void addPlan(String planName, UserEntity user) {
        Plan plan = new Plan();

        plan.setName(planName);
        plan.setUser(user);
        planRepository.save(plan);
    }
}
