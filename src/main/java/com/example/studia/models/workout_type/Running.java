package com.example.studia.models.workout_type;

import com.example.studia.models.WorkoutType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("running")
public class Running  extends WorkoutType {
    // pola: distance, avg_speed, avg_heart_rate
    private double distance;
    private double avg_speed;
    private double avg_heart_rate;

    private boolean internals; // czy trening miał elementy interwałowe, default False

    public Running(double distance, double avg_speed, double avg_heart_rate, boolean intervals) {
        this.distance = distance;
        this.avg_speed = avg_speed;
        this.avg_heart_rate = avg_heart_rate;
        this.internals = intervals;
    }

    // gettery i settery
    public double getDistance() {
        return distance;
    }
    public double getAvg_speed() {
        return avg_speed;
    }
    public double getAvg_heart_rate() {
        return avg_heart_rate;
    }
    public boolean isInternals() {
        return internals;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void setAvg_speed(double avg_speed) {
        this.avg_speed = avg_speed;
    }
    public void setAvg_heart_rate(double avg_heart_rate) {
        this.avg_heart_rate = avg_heart_rate;
    }
    public void setInternals(boolean internals) {
        this.internals = internals;
    }

}
