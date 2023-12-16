package com.example.studia.models;

import com.example.studia.models.WorkoutPlan;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class PlannedWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "workout")
    private List<Exercise> exercises;

    @ManyToOne
    @JoinColumn(name = "workout_plan_id")
    private WorkoutPlan workoutPlan;


    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date; // albo dzien tygodnia moze miec sens tez
}
