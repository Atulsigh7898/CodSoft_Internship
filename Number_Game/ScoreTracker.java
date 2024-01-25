import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
// 7th task
public class ScoreTracker {
    private static final String SCORE_FILE = "score.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = loadScore();
        System.out.println("Your current score: " + score);

        // Simulate a game or an activity where the user attempts something
        boolean userWon = simulateGame();

        if (userWon) {
            score++;
            System.out.println("Congratulations! You won this round.");
        } else {
            System.out.println("Sorry, you lost this round.");
        }

        saveScore(score);
        System.out.println("Your updated score: " + score);

        scanner.close();
    }

    private static boolean simulateGame() {
        // Replace this with the actual logic of your game or activity
        // For simplicity, let's simulate a coin toss
        return Math.random() < 0.5;
    }

    private static int loadScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading score: " + e.getMessage());
        }

        // Return 0 if the score file doesn't exist or an error occurs
        return 0;
    }

    private static void saveScore(int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SCORE_FILE))) {
            writer.println(score);
        } catch (IOException e) {
            System.err.println("Error saving score: " + e.getMessage());
        }
    }
}
