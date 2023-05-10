// Import necessary libraries
import java.util.Scanner;

// Define the GlobalFitness class
public class GlobalFitness {
    // Define instance variables
    private String userName;
    private int age;
    private double weight;
    private double height;
    private double bmi;
    
    // Define a constructor to initialize the instance variables
    public GlobalFitness(String userName, int age, double weight, double height) {
        this.userName = userName;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }
    
    // Define a method to calculate the BMI of the user
    public void calculateBMI() {
        // Calculate the BMI using the weight and height of the user
        bmi = weight / (height * height);
    }
    
    // Define a method to display the user's BMI and health status
    public void displayBMI() {
        // Display the user's BMI and health status based on the calculated BMI
        System.out.println("Your BMI is " + bmi);
        if (bmi < 18.5) {
            System.out.println("You are underweight.");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("You have a normal weight.");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("You are overweight.");
        } else {
            System.out.println("You are obese.");
        }
    }
    
    // Define a method to get the user's input for weight and height
    public void getUserInput() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Get the user's weight
        System.out.print("Enter your weight in kilograms: ");
        weight = scanner.nextDouble();
        
        // Get the user's height
        System.out.print("Enter your height in meters: ");
        height = scanner.nextDouble();
    }
    
    // Define the main method to run the program
    public static void main(String[] args) {
        // Create a GlobalFitness object for the user "John Doe" who is 30 years old, weighs 80 kg, and is 1.8 m tall
        GlobalFitness user = new GlobalFitness("John Doe", 30, 80, 1.8);
        
        // Get the user's input for weight and height
        user.getUserInput();
        
        // Calculate the user's BMI
        user.calculateBMI();
        
        // Display the user's BMI and health status
        user.displayBMI();
    }
}
