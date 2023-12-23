package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("team_sports")
@AllArgsConstructor
@NoArgsConstructor
public class TeamSports  extends WorkoutType {
    private double avgSpeed;
    private int setsNumber;
    private int pointsNumber;
}
