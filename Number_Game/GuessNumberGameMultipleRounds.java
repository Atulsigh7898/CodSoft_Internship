import java.util.Random;
import java.util.Scanner;
// 6th task

public class GuessNumberGameMultipleRounds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            playGame(); // Call the playGame method to encapsulate the game logic

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break; // Exit the loop if the user doesn't want to play again
            }

        } while (true);

        // Close the scanner
        scanner.close();
    }

    // Extracted method for the game logic
    private static void playGame() {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        // Set the maximum number of attempts
        int maxAttempts = 5;
        int attempts = 0;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("Try to guess the number between 1 and 100.");

        // Main game loop
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = new Scanner(System.in).nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return; // Exit the method if the user guessed correctly
            } else if (userGuess < randomNumber) {
                System.out.println("Too low. Try again!");
            } else {
                System.out.println("Too high. Try again!");
            }
        }

        // If the user couldn't guess the number in the allowed attempts
        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + randomNumber + ".");
    }
}
