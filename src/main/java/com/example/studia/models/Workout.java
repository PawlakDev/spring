package com.example.studia.models;

import jakarta.persistence.ForeignKey;

import java.util.Date;

public class Workout {
    // model ma mieć FK do usera oraz do planu treningowego, dziedzczy o typie treningu

    private long id;
    private String name; // nazwa treningu, domyslnie nazwa treningu przyjmuje nazwe typu treningu
    private Date date; // data treningu
    private String description; // opis treningu
    private ForeignKey user; // FK do usera
    private ForeignKey workoutPlan; // FK do planu treningowego


    public Workout(WorkoutType workoutType) {
        this.name = workoutType.getName();
    }

}
