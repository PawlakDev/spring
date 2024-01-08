package com.example.studia.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.DayOfWeek;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlannedWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "workout_type_id")
    private WorkoutType workoutType;

    @ManyToOne
    @JoinColumn(name = "workout_plan_id")
    private WorkoutPlan workoutPlan;

    @NotNull(message = "Workout day must be specified!") // Użycie walidacji Bean Validation - bez własnych adnotacj
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
}
