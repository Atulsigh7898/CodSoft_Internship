import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Specify the range
        int min = 1;
        int max = 100;

        // Generate a random number within the specified range
        int randomNumber = generateRandomNumber(min, max);

        // Prompt the user to enter their guess
        int userGuess = getUserGuess(min, max);

        // Check the user's guess
        checkUserGuess(userGuess, randomNumber);
    }

    private static int generateRandomNumber(int min, int max) {
        // Use the Random class to generate a random number
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
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

    private static void checkUserGuess(int userGuess, int randomNumber) {
        // Check the user's guess and provide feedback
        if (userGuess == randomNumber) {
            System.out.println("Congratulations! Your guess is correct.");
        } else {
            System.out.println("Sorry, your guess is incorrect. The correct number was: " + randomNumber);
        }
    }
}
