package com.example.studia.models;

import org.hibernate.mapping.ForeignKey;

public class WorkoutType {
    private long id;
    private String name; // nazwa typu treningu
    private String description; // opis typu treningu
    private String image; // obrazek typu treningu

    private double time; // czas trwania treningu

    private ForeignKey workoutType; // FK do treningu


    // tu cos do poprawy
    public WorkoutType(String description, String image, ForeignKey workoutType, double time) {
        this.name = workoutType.getClass().getName();
        this.description = description;
        this.image = image;
        this.workoutType = workoutType;
        this.time = time;
    }
    public ForeignKey getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(ForeignKey workoutType) {
        this.workoutType = workoutType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
