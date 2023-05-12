// Import required libraries and packages
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
    int choice = scanner.nextInt();
    
    // Handle user choice
    switch(choice) {
        case 1:
            // Call login method
            login();
            break;
        case 2:
            // Call register method
            register();
            break;
        case 3:
            // Exit the program
            System.out.println("Thank you for using the Global Fitness App. Goodbye!");
            System.exit(0);
            break;
        default:
            // Invalid input
            System.out.println("Invalid choice. Please try again.");
            main(args);
    }
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
        // Display user profile and options
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
                // Display user profile
                System.out.println(userProfiles.get(email));
                login();
                break;
            case 2:
                // Display workout list
                for (Workout workout : workouts) {
                    System.out.println(workout);
                }
                login();
                break;
            case 3:
                // Call create custom workout method
                createCustomWorkout(email);
                break;
            case 4:
                // Call track progress method
                trackProgress(email);
                break;
            case 5:
                // Logout the user
                System.out.println("Logging out...");
                main(new String[] {});
                break;
            default:
                // Invalid input
                System.out.println("Invalid choice. Please try again.");
               
