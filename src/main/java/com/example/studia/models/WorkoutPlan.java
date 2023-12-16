package com.example.studia.models;

import jakarta.persistence.*;

// przechowywanie planu treningowego

@Entity
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "workoutPlan")
    private List<WorkoutType> workoutTypes;

}
