package com.example.studia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import org.hibernate.mapping.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// dzidziczenie z modeli typów?

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // nazwa typu treningu
    private String description; // opis typu treningu
    private String image; // obrazek typu treningu

    private double time; // czas trwania treningu

    private ForeignKey workoutType; // FK do konkretnego typu trenignu


    // tu cos do poprawy
    public WorkoutType(String description, String image, ForeignKey workoutType, double time) {
        this.name = workoutType.getClass().getName();
        this.description = description;
        this.image = image;
        this.workoutType = workoutType;
        this.time = time;
    }
    public ForeignKey getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(ForeignKey workoutType) {
        this.workoutType = workoutType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
