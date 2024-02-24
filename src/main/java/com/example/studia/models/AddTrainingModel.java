package com.example.studia.models;

import java.util.Date;

public class AddTrainingModel {
    private String trainingDate;
    private String trainingType;

    private int trainingDistanse;

    private String trainingTime;

    private String trainingDescription;


    public AddTrainingModel(String trainingDate,String trainingType, int trainingDistanse, String trainingTime, String trainingDescription) {
        this.trainingDate = trainingDate;
        this.trainingType = trainingType;
        this.trainingDistanse = trainingDistanse;
        this.trainingTime = trainingTime;
        this.trainingDescription = trainingDescription;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }

    public String getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(String trainingTime) {
        this.trainingTime = trainingTime;
    }

    public int getTrainingDistanse() {
        return trainingDistanse;
    }

    public void setTrainingDistanse(int trainingDistanse) {
        this.trainingDistanse = trainingDistanse;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }
}
