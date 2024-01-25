import java.util.*;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        // Specify the range
        int min = 1;
        int max = 100;

        // Generate a random number within the specified range
        int randomNumber = generateRandomNumber(min, max);

        // Output the random number
        System.out.println("Random Number between " + min + " and " + max + ": " + randomNumber);
    }

    private static int generateRandomNumber(int min, int max) {
        // Use the Random class to generate a random number
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}