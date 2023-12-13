package com.example.studia.models.workout_type;

public class Swimming {
    // pola distance, avg_speed, avg_heart_rate, style
    private double distance; // w metrach lub km?
    private double avg_speed;
    private double avg_heart_rate;
    private String style;

    public Swimming(double distance, double avg_speed, double avg_heart_rate, String style) {
        this.distance = distance;
        this.avg_speed = avg_speed;
        this.avg_heart_rate = avg_heart_rate;
        this.style = style;
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
    public String getStyle() {
        return style;
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
    public void setStyle(String style) {
        this.style = style;
    }
}
