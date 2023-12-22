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
    private double avg_speed;
    private double avg_heart_rate;
    private int sets_number;
    private int points_number;
}
