package com.example.studia.models.workout_type;


//  pola: distance, time, avg_speed, avg_heart_rate
public class Bike {
    private double distance;
    private double time;
    private double avg_speed;
    private double avg_heart_rate;

    public Bike() {
    }
    public Bike(double distance, double time, double avg_speed, double avg_heart_rate) {
        this.distance = distance;
        this.time = time;
        this.avg_speed = avg_speed;
        this.avg_heart_rate = avg_heart_rate;
    }

    //gettery i settery
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double getTime() {
        return time;
    }
    public void setTime(double time) {
        this.time = time;
    }
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
}
