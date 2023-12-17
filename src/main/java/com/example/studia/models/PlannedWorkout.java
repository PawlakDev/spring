package com.example.studia.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlannedWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneyToOne
    @JoinColumn(name = "workout_type_id")
    private WorkoutType workoutType;


    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date; // albo dzien tygodnia moze miec sens tez
}
