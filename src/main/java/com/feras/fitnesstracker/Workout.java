package com.feras.fitnesstracker;

public class Workout {

    private final String exerciseName;
    private final int durationMinutes;

    public Workout(String exerciseName, int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException(
                    "Workout duration must be greater than zero."
            );
        }

        this.exerciseName = exerciseName;
        this.durationMinutes = durationMinutes;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }
}
