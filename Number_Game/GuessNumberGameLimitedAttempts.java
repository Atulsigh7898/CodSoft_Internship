import java.util.Random;
import java.util.Scanner;
// 5th task
public class GuessNumberGameLimitedAttempts {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        // Set the maximum number of attempts
        int maxAttempts = 5;
        int attempts = 0;

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("Try to guess the number between 1 and 100.");

        // Main game loop
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low. Try again!");
            } else {
                System.out.println("Too high. Try again!");
            }
        }

        // If the user couldn't guess the number in the allowed attempts
        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + randomNumber + ".");
        }

        // Close the scanner
        scanner.close();
    }
}
