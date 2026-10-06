package com.feras.fitnesstracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FitnessTracker {

    private final List<Workout> workouts;
    private Goal goal;

    public FitnessTracker() {
        workouts = new ArrayList<>();
    }

    public void logWorkout(Workout workout) {
        workouts.add(workout);
    }

    public List<Workout> getWorkouts() {
        return Collections.unmodifiableList(workouts);
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Goal getGoal() {
        return goal;
    }

    public int calculateProgress() {
        int totalMinutes = 0;

        for (Workout workout : workouts) {
            totalMinutes += workout.getDurationMinutes();
        }

        return totalMinutes;
    }
}
