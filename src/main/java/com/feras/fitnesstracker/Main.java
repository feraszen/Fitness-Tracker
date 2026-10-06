package com.feras.fitnesstracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FitnessTracker tracker = new FitnessTracker();

        boolean running = true;

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> logWorkout(scanner, tracker);
                case "2" -> setGoal(scanner, tracker);
                case "3" -> viewProgress(tracker);
                case "4" -> viewWorkouts(tracker);
                case "5" -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using Fitness Tracker!");
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("===== Fitness Tracker =====");
        System.out.println();
        System.out.println("1. Log Workout");
        System.out.println("2. Set Goal");
        System.out.println("3. View Progress");
        System.out.println("4. View Workouts");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void logWorkout(Scanner scanner, FitnessTracker tracker) {
        System.out.print("Exercise name: ");
        String exerciseName = scanner.nextLine();

        System.out.print("Duration in minutes: ");
        int durationMinutes = Integer.parseInt(scanner.nextLine());

        tracker.logWorkout(new Workout(exerciseName, durationMinutes));

        System.out.println("Workout logged successfully!");
    }

    private static void setGoal(Scanner scanner, FitnessTracker tracker) {
        System.out.print("Goal description: ");
        String description = scanner.nextLine();

        System.out.print("Target minutes: ");
        int targetMinutes = Integer.parseInt(scanner.nextLine());

        tracker.setGoal(new Goal(description, targetMinutes));

        System.out.println("Goal set successfully!");
    }

    private static void viewProgress(FitnessTracker tracker) {
        System.out.println(
                "Total workout minutes: " + tracker.calculateProgress()
        );

        if (tracker.getGoal() != null) {
            System.out.println(
                    "Goal: " + tracker.getGoal().getDescription()
                            + " - " + tracker.getGoal().getTargetMinutes()
                            + " minutes"
            );
        } else {
            System.out.println("No goal has been set.");
        }
    }

    private static void viewWorkouts(FitnessTracker tracker) {
        if (tracker.getWorkouts().isEmpty()) {
            System.out.println("No workouts logged.");
            return;
        }

        System.out.println("Workouts:");

        for (Workout workout : tracker.getWorkouts()) {
            System.out.println(
                    "- " + workout.getExerciseName()
                            + ": " + workout.getDurationMinutes()
                            + " minutes"
            );
        }
    }
}
