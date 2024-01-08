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
    private int minReps;
    private int maxReps; // walidacja min < max
    private double minWeight;
    private double maxWeight; // walidacja min < max
    private int series;
    private double restTime;

}
