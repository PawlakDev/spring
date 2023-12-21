package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("gym")
@AllArgsConstructor
@NoArgsConstructor
public class Gym extends WorkoutType {
    private int min_reps;
    private int max_reps; // walidacja min < max
    private double min_weight;
    private double max_weight; // walidacja min < max
    private int series;
    private double rest_time;

}
