# Fitness Tracker

A simple Java Fitness Tracker application developed for SDAT and DevOps QAP 1.

## Project Overview

The Fitness Tracker is a basic Java application that allows users to:

- Log workouts
- Track workout progress
- Set a fitness goal

The project uses basic Java classes and object-oriented programming concepts and does not use an external application framework.

The project was intentionally kept simple to match the QAP requirements.

## Technologies Used

- Java 26
- Maven
- JUnit 5
- Git
- GitHub
- GitHub Actions

## Project Structure

```text
Fitness Tracker/
├── .github/
│   └── workflows/
│       └── maven.yml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── feras/
│   │               └── fitnesstracker/
│   │                   ├── FitnessTracker.java
│   │                   ├── Goal.java
│   │                   └── Workout.java
│   └── test/
│       └── java/
│           └── com/
│               └── feras/
│                   └── fitnesstracker/
│                       └── FitnessTrackerTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## How the Application Works

### Workout

The `Workout` class represents a workout.

Each workout stores:

- Exercise name
- Workout duration in minutes

A workout cannot be created with a duration of zero or less.

### Goal

The `Goal` class represents a fitness goal.

Each goal stores:

- Goal description
- Target duration in minutes

A goal cannot be created with a target of zero or less.

### FitnessTracker

The `FitnessTracker` class manages the application data.

It allows the application to:

- Log workouts
- Retrieve logged workouts
- Set a fitness goal
- Retrieve the current goal
- Calculate total workout progress

Progress is calculated by adding the duration of all logged workouts.

## Unit Tests

The project contains 12 unit tests, which is more than the minimum requirement of 10 tests.

The tests cover both positive and negative scenarios.

### Positive Scenarios

The tests cover:

- Creating a workout
- Retrieving a workout name
- Retrieving workout duration
- Logging a workout
- Logging multiple workouts
- Starting with an empty workout list
- Creating a goal
- Setting a goal
- Calculating progress with no workouts
- Calculating progress from multiple workouts

### Negative Scenarios

The project also tests invalid input:

- A workout with zero duration is rejected.
- A goal with zero target minutes is rejected.

### Assertions Used

The tests use a mix of JUnit 5 assertions:

- `assertEquals`
- `assertNotNull`
- `assertTrue`
- `assertThrows`

### Test Result

The local Maven test run completed successfully:

```text
Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## Clean Code Examples

The project follows simple clean-code practices through meaningful names, clear validation, small focused methods, and straightforward class responsibilities.

### Example 1: Meaningful Class and Variable Names

The `FitnessTracker` class uses names that clearly describe the data and responsibilities:

```java
public class FitnessTracker {

    private final List<Workout> workouts;
    private Goal goal;
}
```

Names such as `FitnessTracker`, `Workout`, `Goal`, `workouts`, and `goal` make the purpose of the code clear.

**Screenshot:**

_Add a screenshot of this section of `FitnessTracker.java` here._

### Example 2: Clear Validation

The `Workout` constructor validates the duration before creating the object:

```java
public Workout(String exerciseName, int durationMinutes) {
    if (durationMinutes <= 0) {
        throw new IllegalArgumentException(
                "Workout duration must be greater than zero."
        );
    }

    this.exerciseName = exerciseName;
    this.durationMinutes = durationMinutes;
}
```

The validation is kept close to the data being created, and the exception message explains the problem clearly.

**Screenshot:**

_Add a screenshot of this section of `Workout.java` here._

### Example 3: Small Focused Method

The `calculateProgress()` method has one clear responsibility: calculate the total duration of all logged workouts.

```java
public int calculateProgress() {
    int totalMinutes = 0;

    for (Workout workout : workouts) {
        totalMinutes += workout.getDurationMinutes();
    }

    return totalMinutes;
}
```

The method is short, easy to read, and focused on one task.

**Screenshot:**

_Add a screenshot of this section of `FitnessTracker.java` here._

## Maven Dependencies

The project uses Maven for project and dependency management.

JUnit 5 is included in `pom.xml` for unit testing.

The main testing dependency is:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>${junit.version}</version>
    <scope>test</scope>
</dependency>
```

The project does not use an external application framework.

### Dependency Source

JUnit 5 is obtained through Maven Central using the JUnit Jupiter Maven dependency.

Project documentation:

https://junit.org/junit5/

## GitHub Actions

The project uses GitHub Actions to automatically run Maven tests.

The workflow is located at:

```text
.github/workflows/maven.yml
```

The workflow is configured to run when:

- Code is pushed to the `main` branch.
- A Pull Request targets the `main` branch.

The workflow:

1. Checks out the repository.
2. Sets up Java 26.
3. Uses Maven caching.
4. Runs `mvn test`.

### GitHub Actions Result

The first GitHub Actions run completed successfully on the `main` branch.

**Screenshot:**

_Add a screenshot of the successful GitHub Actions run here._

## Git Workflow

The project uses Git branching and Pull Request workflow.

The main branch is:

```text
main
```

A feature branch has been created for project documentation:

```text
feature/add-readme
```

The intended workflow is:

```text
main
  │
  └── feature/add-readme
          │
          └── Pull Request
                    │
                    ▼
                  main
```

The feature branch will be submitted through a Pull Request before being merged into `main`.

GitHub Actions is configured to run tests for Pull Requests targeting `main`.

## Problems Encountered

One of the main challenges during the project setup was configuring the development environment and ensuring that the Maven project worked correctly with Java 26.

The project was tested locally using Maven before being pushed to GitHub.

The GitHub Actions workflow was then configured and successfully executed the Maven tests.

Another important part of the setup was implementing the required Git workflow using a feature branch and Pull Request process.

## Running the Project

### Run the Tests

From the project directory, run:

```bash
mvn test
```

A successful run should report that all tests pass.

### Validate the Maven Project

```bash
mvn validate
```

## Repository

GitHub repository:

https://github.com/feraszen/Fitness-Tracker

## QAP Requirements Checklist

- [x] Java application
- [x] Fitness Tracker topic
- [x] Object-oriented design
- [x] No external framework
- [x] At least 10 unit tests
- [x] Positive test scenarios
- [x] Negative test scenarios
- [x] JUnit 5
- [x] Maven configuration
- [x] GitHub Actions
- [x] Successful GitHub Actions run
- [x] Git branching
- [ ] Pull Request workflow completed
- [x] README documentation
- [x] Three Clean Code examples documented
- [ ] Screenshots added to the README
- [x] Dependencies documented
- [x] QAP problems documented
