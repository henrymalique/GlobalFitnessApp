import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Class to represent user profile
class UserProfile {
    private String name;
    private int age;
    private double weight;
    private double bodyFatPercentage;
    private String goal;

    public UserProfile(String name, int age, double weight, double bodyFatPercentage, String goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.bodyFatPercentage = bodyFatPercentage;
        this.goal = goal;
    }

    public void updateBodyFatPercentage(double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public void updateWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    // Override toString() method to display user profile information
    @Override
    public String toString() {
        return "User Profile: " +
                "Name: " + name +
                ", Age: " + age +
                ", Weight: " + weight +
                ", Body Fat Percentage: " + bodyFatPercentage +
                ", Goal: " + goal;
    }
}

// Class to represent a workout
class Workout {
    private String name;
    private int duration;
    private List<Exercise> exercises;

    public Workout(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    // Override toString() method to display workout information
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout: ").append(name).append(", Duration: ").append(duration).append(" minutes\n");
        sb.append("Exercises:\n");
        for (Exercise exercise : exercises) {
            sb.append(exercise).append("\n");
        }
        return sb.toString();
    }
}

// Class to represent an exercise
class Exercise {
    private String name;
    private int sets;
    private int reps;

    public Exercise(String name, int sets, int reps) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
    }

    // Override toString() method to display exercise information
    @Override
    public String toString() {
        return "Exercise: " + name + ", Sets: " + sets + ", Reps: " + reps;
    }
}

// Global Fitness App class
public class GlobalFitnessApp {

    // Define data structures for storing user and workout information
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, UserProfile> userProfiles = new HashMap<>();
    private static List<Workout> workouts = new ArrayList<>();

    // Define main method
    public static void main(String[] args) {
        // Display welcome message and options
        System.out.println("Welcome to the Global Fitness App!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        // Read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Handle user choice
        switch (choice) {
            case 1:
                // Call login method if user wants to log in
                login();
                break;
            case 2:
                // Call register method if user wants to register
                register();
                break;
            case 3:
                // Exit the program if user wants to exit
                System.out.println("Thank you for using the Global Fitness App. Goodbye!");
                System.exit(0);
                break;
            default:
                // Invalid input
                System.out.println("Invalid input. Please try again.");
                main(args); // Call main method again to give user another chance to input a valid option
        }
        scanner.close();
    }

    // Define login method
    public static void login() {
        // Prompt user for email and password
        System.out.println("Please enter your email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        // Check if user exists and password is correct
        if (users.containsKey(email) && users.get(email).equals(password)) {
            // Display user profile and options if login is successful
            System.out.println("Welcome back, " + userProfiles.get(email).getName() + "!");
            System.out.println("1. View profile");
            System.out.println("2. View workouts");
            System.out.println("3. Create custom workout");
            System.out.println("4. Track progress");
            System.out.println("5. Logout");

            // Read user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Handle user choice
            switch (choice) {
                case 1:
                    // Display user profile if user wants to view it
                    System.out.println(userProfiles.get(email));
                    login(); // Call login method again to give user another chance to choose an option
                    break;
                case 2:
                    // Display workout list if user wants to view it
                    for (Workout workout : workouts) {
                        System.out.println(workout);
                    }
                    login(); // Call login method again to give user another chance to choose an option
                    break;
                case 3:
                    // Call create custom workout method if user wants to create a custom workout
                    createCustomWorkout(email);
                    login(); // Call login method again to give user another chance to choose an option
                    break;
                case 4:
                    // Call track progress method if user wants to track their progress
                    trackProgress(email);
                    login(); // Call login method again to give user another chance to choose an option
                    break;
                case 5:
                    // Logout the user
                    System.out.println("Logging out...");
                    main(new String[]{});
                    break;
                default:
                    // Invalid input
                    System.out.println("Invalid input. Please try again.");
                    login();
            }
        } else {
            System.out.println("Invalid email or password. Please try again.");
            login();
        }
        scanner.close();
    }

    // Define register method
    public static void register() {
        // Prompt user for email and password
        System.out.println("Please enter your email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        // Check if email is already registered
        if (users.containsKey(email)) {
            System.out.println("An account with this email already exists. Please try again with a different email.");
            register();
        } else {
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

            // Prompt user for profile information
            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            System.out.println("Please enter your age:");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.println("Please enter your weight in kg:");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.println("Please enter your body fat percentage:");
            double bodyFatPercentage = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.println("Please enter your fitness goal:");
            String goal = scanner.nextLine();

            // Create user profile
            UserProfile userProfile = new UserProfile(name, age, weight, bodyFatPercentage, goal);
            users.put(email, password);
            userProfiles.put(email, userProfile);

            System.out.println("Registration successful. Welcome to the Global Fitness App, " + name + "!");
            login();
        }
        scanner.close();
    }

    // Define create custom workout method
    public static void createCustomWorkout(String email) {
        // Prompt user for workout name and duration
        System.out.println("Please enter the workout name:");
        Scanner scanner = new Scanner(System.in);
        String workoutName = scanner.nextLine();
        System.out.println("Please enter the workout duration in minutes:");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Create workout object
        Workout workout = new Workout(workoutName, duration);

        // Prompt user for exercise information
        boolean addExercise = true;
        while (addExercise) {
            System.out.println("Please enter the exercise name:");
            String exerciseName = scanner.nextLine();
            System.out.println("Please enter the number of sets:");
            int sets = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.println("Please enter the number of reps:");
            int reps = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Create exercise object and add it to the workout
            Exercise exercise = new Exercise(exerciseName, sets, reps);
            workout.addExercise(exercise);

            System.out.println("Exercise added to workout.");

            // Prompt user if they want to add another exercise
            System.out.println("Do you want to add another exercise? (yes/no)");
            String choice = scanner.nextLine();
            addExercise = choice.equalsIgnoreCase("yes");
        }

        // Add the completed workout to the list
        workouts.add(workout);

        // Display success message
        System.out.println("Custom workout created successfully.");
    }

    // Define track progress method
    public static void trackProgress(String email) {
        // Get user profile
        UserProfile userProfile = userProfiles.get(email);

        // Prompt user for weight and body fat percentage
        System.out.println("Please enter your updated weight in kg:");
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.println("Please enter your updated body fat percentage:");
        double bodyFatPercentage = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        // Update user profile with new weight and body fat percentage
        userProfile.updateWeight(weight);
        userProfile.updateBodyFatPercentage(bodyFatPercentage);

        // Display success message
        System.out.println("Progress tracked successfully.");
    }
}
