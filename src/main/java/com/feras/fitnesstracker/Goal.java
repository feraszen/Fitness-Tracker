package com.feras.fitnesstracker;

public class Goal {

    private final String description;
    private final int targetMinutes;

    public Goal(String description, int targetMinutes) {
        if (targetMinutes <= 0) {
            throw new IllegalArgumentException(
                    "Goal target must be greater than zero."
            );
        }

        this.description = description;
        this.targetMinutes = targetMinutes;
    }

    public String getDescription() {
        return description;
    }

    public int getTargetMinutes() {
        return targetMinutes;
    }
}
