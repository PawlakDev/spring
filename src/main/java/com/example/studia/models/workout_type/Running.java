package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("running")
@AllArgsConstructor
@NoArgsConstructor
public class Running  extends WorkoutType {
    private double distance;
    private double avgSpeed;
    private double avgHeartRate;
    private boolean internals; // czy trening miał elementy interwałowe, default False


}
