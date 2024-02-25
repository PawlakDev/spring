package com.example.studia.services;

import com.example.studia.models.AddTrainingModel;
import com.example.studia.models.Workouts;
import com.example.studia.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutsService {
    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workouts> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public void addTraining(String trainingDate,String trainingType, int trainingDistanse, long trainingTime, String trainingDescription, long idu) {
        Workouts training = new Workouts();

        training.setIdu(idu);
        training.setDate(trainingDate);
        training.setType(trainingType);
        training.setKm(trainingDistanse);
        training.setTime(trainingTime);
        training.setDescription(trainingDescription);
        workoutRepository.save(training);
    }

}
