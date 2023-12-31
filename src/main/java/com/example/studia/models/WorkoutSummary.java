package com.example.studia.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutSummary {
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "planned_workout_id")
    private PlannedWorkout plannedWorkout;
    // na podstawie tego pola będziemy wiedzieć, czy trening odbył sie zgodnie z planem

    public WorkoutSummary(WorkoutType workoutType) {
        this.name = workoutType.getName();
    }

    // Settery
    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
