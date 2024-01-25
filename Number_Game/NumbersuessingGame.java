import java.util.Random;
import java.util.Scanner;

public class NumbersuessingGame {
    public static void main(String[] args) {
        // Specify the range
        int min = 1;
        int max = 100;

        // Generate a random number within the specified range
        int randomNumber = generateRandomNumber(min, max);

        // Play the number guessing game
        playNumberGuessingGame(randomNumber, min, max);
    }

    private static int generateRandomNumber(int min, int max) {
        // Use the Random class to generate a random number
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static void playNumberGuessingGame(int randomNumber, int min, int max) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + min + " and " + max + ".");

        int attempts = 0;
        boolean correctGuess = false;

        do {
            int userGuess = getUserGuess(min, max);

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! Your guess is correct.");
                correctGuess = true;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attempts++;
        } while (!correctGuess);

        System.out.println("You guessed the number in " + attempts + " attempts.");
    }

    private static int getUserGuess(int min, int max) {
        // Prompt the user to enter their guess
        Scanner scanner = new Scanner(System.in);
        int userGuess;

        do {
            System.out.println("Enter your guess between " + min + " and " + max + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            userGuess = scanner.nextInt();
        } while (userGuess < min || userGuess > max);

        return userGuess;
    }
}

