package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("other")
@AllArgsConstructor
@NoArgsConstructor
public class Other  extends WorkoutType {
    private double avg_heart_rate;
    private String name;

    public Other(String namee){
        this.name = name;
    }
}
