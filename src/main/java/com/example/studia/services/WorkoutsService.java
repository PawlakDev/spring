package com.example.studia.services;

import com.example.studia.models.AddTrainingModel;
import com.example.studia.models.Plan;
import com.example.studia.models.Workouts;
import com.example.studia.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class WorkoutsService {
    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workouts> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public void addTraining(String trainingDate,String trainingType, int trainingDistanse, long trainingTime, String trainingDescription, long idu, Plan plan) {
        Workouts training = new Workouts();

        training.setIdu(idu);
        training.setDate(trainingDate);
        training.setType(trainingType);
        training.setKm(trainingDistanse);
        training.setTime(trainingTime);
        training.setDescription(trainingDescription);
        training.setPlan(plan);
        workoutRepository.save(training);
    }

    public List<Workouts> sortWorkouts(List<Workouts> workouts, String sortBy) {

        switch (sortBy) {
            case "date":
                Collections.sort(workouts, Comparator.comparing(Workouts::getDate));
                break;
            case "type":
                Collections.sort(workouts, Comparator.comparing(Workouts::getType));
                break;
            case "time":
                Collections.sort(workouts, Comparator.comparing(Workouts::getTime).reversed());
                break;
            case "km":
                Collections.sort(workouts, Comparator.comparing(Workouts::getKm).reversed());
                break;
            default:
                System.out.println("Łerror (nie pasuje)");
                break;
        }
        return workouts;
    }

}
