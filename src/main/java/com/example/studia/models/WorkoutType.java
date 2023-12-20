package com.example.studia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import org.hibernate.mapping.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "workout_type")
public class WorkoutType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // nazwa typu treningu
    private String description; // opis typu treningu
    private String image; // obrazek typu treningu

    private double time; // czas trwania treningu

    @OneToMany(mappedBy = "workout")
    private List<Exercise> exercises;


    // model z ktorego dziedzicza modele typu treningu
    public WorkoutType(String description, String image, ForeignKey workoutType, double time) {
        this.name = workoutType.getClass().getName();
        this.description = description;
        this.image = image;
        this.time = time;
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
