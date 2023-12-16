package com.example.studia.models;

import jakarta.persistence.*;

@Entity
public class WorkoutSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // zastanowić się pomiędzy relacjami między tym modelem a PlannedWorkout i Workout
}
