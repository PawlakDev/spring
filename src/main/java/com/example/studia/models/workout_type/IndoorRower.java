package com.example.studia.models.workout_type;

public class IndoorRower {
    // distance, avg_speed, avg_heart_rate, avg_watts
    private double distance; // walidacja na dystans
    private double avgSpeed;
    private double avgHeartRate; // walidacja na tętno
    private double avgWatts;

    public IndoorRower(double distance, double avgSpeed, double avgHeartRate, double avgWatts) {
        this.distance = distance;
        this.avgSpeed = avgSpeed;
        this.avgHeartRate = avgHeartRate;
        this.avgWatts = avgWatts;
    }
    // getters and setters
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double getAvgSpeed() {
        return avgSpeed;
    }
    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }
    public double getAvgHeartRate() {
        return avgHeartRate;
    }
    public void setAvgHeartRate(double avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }
    public double getAvgWatts() {
        return avgWatts;
    }
    public void setAvgWatts(double avgWatts) {
        this.avgWatts = avgWatts;
    }

}
