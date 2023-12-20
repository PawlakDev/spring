package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("team_sports")
public class TeamSports  extends WorkoutType {
    // pola: avg_speed, avg_heart_rate, sets_number, points_number
    // metody: get, set, toString
    private double avg_speed;
    private double avg_heart_rate;
    private int sets_number;
    private int points_number;

    TeamSports(){

    }
    TeamSports(double avg_speed, double avg_heart_rate, int sets_number, int points_number){
        this.avg_speed = avg_speed;
        this.avg_heart_rate = avg_heart_rate;
        this.sets_number = sets_number;
        this.points_number = points_number;
    }
    // gettery i settery
    public double getAvg_speed() {
        return avg_speed;
    }
    public void setAvg_speed(double avg_speed) {
        this.avg_speed = avg_speed;
    }
    public double getAvg_heart_rate() {
        return avg_heart_rate;
    }
    public void setAvg_heart_rate(double avg_heart_rate) {
        this.avg_heart_rate = avg_heart_rate;
    }
    public int getSets_number() {
        return sets_number;
    }
    public void setSets_number(int sets_number) {
        this.sets_number = sets_number;
    }
    public int getPoints_number() {
        return points_number;
    }
    public void setPoints_number(int points_number) {
        this.points_number = points_number;
    }
}
