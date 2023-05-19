// Import required libraries and packages
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class UserProfile {

    public UserProfile(String name, int age, double weight, double bodyFatPercentage, String goal) {
        // Initialize the UserProfile instance with the provided arguments
    }

    public void updateBodyFatPercentage(double bodyFatPercentage) {
    }

    public void updateWeight(double weight) {
    }

    public String getName() {
        return null;
    }
    

}

class Workout {

    public Workout(String name, int duration, String description) {
        // Initialize the Workout instance with the provided arguments
    }

    public void addExercise(Exercise exercise) {
    }
    
}

class Exercise {

    public Exercise(String name, int sets, int reps) {
        // Initialize the Exercise instance with the provided arguments
    }
    
}
// Global Fitness App class
public class GlobalFitnessApp {

    // Define data structures for storing user and workout information
    private static Map<String, String> users = new HashMap<String, String>();
    private static Map<String, UserProfile> userProfiles = new HashMap<String, UserProfile>();
    private static List<Workout> workouts = new ArrayList<Workout>();

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
        scanner.close();

        // Handle user choice
        switch(choice) {
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
    }

    // Define login method
    public static void login() {

        // Prompt user for email and password
        System.out.println("Please enter your email:");
        try (Scanner scanner = new Scanner(System.in)) {
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

                // Handle user choice
                switch(choice) {
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
                        main(new String[] {});
                        break;
                     default:
                        // Invalid input
                        System.out.println("Invalid input. Please try again.");
                        login();
                }}
        }
        }
        
        
        // Define register method
    public static void register() {
        // Prompt user for email and password
        System.out.println("Please enter your email:");
        try (Scanner scanner = new Scanner(System.in)) {
            String email = scanner.nextLine();
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();
            
            
                // Check if email is already registered
   if (users.containsKey(email)) {
            System.out.println("An account with this email already exists. Please try again with a different email.");
            register();
   } else {
            // Prompt user for profile information
            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            System.out.println("Please enter your age:");
            int age = scanner.nextInt();
            System.out.println("Please enter your weight (in kg):");
            double weight = scanner.nextDouble();
            System.out.println("Please enter your height (in cm):");
            double height = scanner.nextDouble();
            System.out.println("Please enter your fitness goal:");
            String fitnessGoal = scanner.nextLine();
            fitnessGoal = scanner.nextLine();
            
            // Create new user profile
            UserProfile userProfile = new UserProfile(name, age, weight, height, fitnessGoal);
            
            // Store user information
            users.put(email, password);
            userProfiles.put(email, userProfile);
            
            // Display success message and options
            System.out.println("Account created successfully!");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            
            // Read user input
            int choice = scanner.nextInt();
            
            // Handle user choice
            switch(choice) {
                case 1:
                    // Call login method
                    login();
                    break;
                case 2:
                    // Exit the program
                    System.out.println("Thank you for using the Global Fitness App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    // Invalid input
                    System.out.println("Invalid input. Please try again.");
                    register();
            }
   }
        }
}

// Define create custom workout method
public static void createCustomWorkout(String email) {
    // Prompt user for workout information
    System.out.println("Please enter the name of your custom workout:");
    try (Scanner scanner = new Scanner(System.in)) {
        String name = scanner.nextLine();
        System.out.println("Please enter the duration of your custom workout (in minutes):");
        int duration = scanner.nextInt();
        scanner.nextLine();
        
        // Create new workout
        Workout workout = new Workout(name, duration, email);
        
        // Add exercises to workout
        System.out.println("Add exercises to your workout (enter 'done' to finish):");
        while (true) {
            System.out.println("Exercise name:");
            String exerciseName = scanner.nextLine();
            if (exerciseName.equals("done")) {
                break;
            }
            System.out.println("Number of sets:");
            int sets = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Number of reps per set:");
            int reps = scanner.nextInt();
            scanner.nextLine();
            Exercise exercise = new Exercise(exerciseName, sets, reps);
            workout.addExercise(exercise);
        }
        
        // Add workout to list of workouts
        workouts.add(workout);
    }
    // Display success message
    System.out.println("Custom workout created successfully!");
}

// Define track progress method
public static void trackProgress(String email) {
    // Prompt user for progress information
    System.out.println("Please enter your weight (in kg):");
    try (Scanner scanner = new Scanner(System.in)) {
        double weight = scanner.nextDouble();
        System.out.println("Please enter your body fat percentage:");
        double bodyFatPercentage = scanner.nextDouble();
        
        // Update user profile with progress information
        userProfiles.get(email).updateWeight(weight);
        userProfiles.get(email).updateBodyFatPercentage(bodyFatPercentage);
    }
    System.out.println("Progress updated successfully!");
    login();
}
}

               
