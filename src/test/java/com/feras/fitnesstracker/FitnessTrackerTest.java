package com.feras.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FitnessTrackerTest {

    @Test
    void shouldCreateWorkout() {
        Workout workout = new Workout("Running", 30);

        assertNotNull(workout);
    }

    @Test
    void shouldReturnWorkoutName() {
        Workout workout = new Workout("Running", 30);

        assertEquals("Running", workout.getExerciseName());
    }

    @Test
    void shouldReturnWorkoutDuration() {
        Workout workout = new Workout("Running", 30);

        assertEquals(30, workout.getDurationMinutes());
    }

    @Test
    void shouldLogWorkout() {
        FitnessTracker tracker = new FitnessTracker();
        Workout workout = new Workout("Running", 30);

        tracker.logWorkout(workout);

        assertEquals(1, tracker.getWorkouts().size());
    }

    @Test
    void shouldLogMultipleWorkouts() {
        FitnessTracker tracker = new FitnessTracker();

        tracker.logWorkout(new Workout("Running", 30));
        tracker.logWorkout(new Workout("Cycling", 45));

        assertEquals(2, tracker.getWorkouts().size());
    }

    @Test
    void shouldStartWithNoWorkouts() {
        FitnessTracker tracker = new FitnessTracker();

        assertTrue(tracker.getWorkouts().isEmpty());
    }

    @Test
    void shouldCreateGoal() {
        Goal goal = new Goal("Weekly cardio", 150);

        assertNotNull(goal);
    }

    @Test
    void shouldSetGoal() {
        FitnessTracker tracker = new FitnessTracker();
        Goal goal = new Goal("Weekly cardio", 150);

        tracker.setGoal(goal);

        assertEquals(goal, tracker.getGoal());
    }

    @Test
    void shouldHaveZeroProgressWithoutWorkouts() {
        FitnessTracker tracker = new FitnessTracker();

        assertEquals(0, tracker.calculateProgress());
    }

    @Test
    void shouldCalculateProgressFromMultipleWorkouts() {
        FitnessTracker tracker = new FitnessTracker();

        tracker.logWorkout(new Workout("Running", 30));
        tracker.logWorkout(new Workout("Cycling", 45));

        assertEquals(75, tracker.calculateProgress());
    }

    @Test
    void shouldRejectWorkoutWithZeroDuration() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Workout("Running", 0)
        );
    }

    @Test
    void shouldRejectGoalWithZeroTarget() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Goal("Weekly cardio", 0)
        );
    }
}
