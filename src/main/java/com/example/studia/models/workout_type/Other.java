package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("other")
public class Other  extends WorkoutType {
    private double avg_heart_rate;
    private String name;

    public Other(String name, int heart_rate){
        this.name = name;
        this.avg_heart_rate = heart_rate;
    }
    public Other(){
        this.name = "inne";
        this.avg_heart_rate = 0;
    }
}
