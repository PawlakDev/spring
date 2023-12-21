package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("indoor_rower")
@AllArgsConstructor
@NoArgsConstructor
public class IndoorRower  extends WorkoutType {
    private double distance; // walidacja na dystans
    private double avgSpeed;
    private double avgHeartRate; // walidacja na tętno
    private double avgWatts;
}
