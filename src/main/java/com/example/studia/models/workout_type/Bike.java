package com.example.studia.models.workout_type;


import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("bike")
@AllArgsConstructor
@NoArgsConstructor
public class Bike extends WorkoutType {
    private double distance;
    private double time;
    private double avgSpeed;
    private double avgHeartRate;

}
