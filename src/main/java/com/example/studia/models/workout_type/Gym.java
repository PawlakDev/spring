package com.example.studia.models.workout_type;

import com.example.studia.models.Exercise;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Gym {
    // pola: min reps, max reps, min weight, max weight, series, rest_time
    private int min_reps;
    private int max_reps; // walidacja min < max
    private double min_weight;
    private double max_weight; // walidacja min < max
    private int series;
    private double rest_time;

    // czy to ma sens
    @OneToMany(mappedBy = "workout")
    private List<Exercise> exercises;

    public Gym() {
    }
    public Gym(int min_reps, int max_reps, double min_weight, double max_weight, int series, double rest_time) {
        this.min_reps = min_reps;
        this.max_reps = max_reps;
        this.min_weight = min_weight;
        this.max_weight = max_weight;
        this.series = series;
        this.rest_time = rest_time;

    }

}
