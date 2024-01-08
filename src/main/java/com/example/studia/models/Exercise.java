package com.example.studia.models;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.format.annotation.NumberFormat;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // import org.springframework.boot.convert.DurationFormat; idk czy z tego skorzystac?
    @NumberFormat
    private Integer duration; // Integer zamiast int, aby obsłużyć wartość null

    @ManyToOne
    @JoinColumn(name = "workout_type_id")
    private WorkoutType workoutType;

    // Konstruktor z wymaganymi polami
    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

}