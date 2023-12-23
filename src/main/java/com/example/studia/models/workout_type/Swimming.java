package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("swimming")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Swimming  extends WorkoutType {
    private double distance; // w metrach lub km?
    private double avgSpeed;
    private double avgHeartRate;
    private String style;

}
