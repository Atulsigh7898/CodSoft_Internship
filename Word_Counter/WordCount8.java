import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//8th task

public class WordCount8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String content = "";
        int totalWordCount = 0;
        int uniqueWordCount = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();

        switch (option) {
            case 1:
                System.out.println("Enter your text:");
                content = scanner.nextLine();
                analyzeWords(content, wordFrequency);
                break;
            case 2:
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                content = readFromFile(filePath);
                analyzeWords(content, wordFrequency);
                break;
            default:
                System.out.println("Invalid option");
        }

        System.out.println("Content stored in a string:");
        System.out.println(content);

        // Display statistics
        System.out.println("\nStatistics:");
        System.out.println("Total number of words: " + totalWordCount);
        System.out.println("Number of unique words: " + uniqueWordCount);
        System.out.println("Word frequency:");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }

        // Save to a file if user wants to
        System.out.println("\nDo you want to save the statistics to a file? (yes/no)");
        String saveOption = scanner.nextLine().toLowerCase();

        if (saveOption.equals("yes")) {
            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine();
            saveStatisticsToFile(totalWordCount, uniqueWordCount, wordFrequency, fileName);
            System.out.println("Statistics saved to file: " + fileName);
        }

        scanner.close();
    }

    private static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return content.toString();
    }

    private static void analyzeWords(String content, Map<String, Integer> wordFrequency) {
        // Split the content into words using space or punctuation as delimiters
        String[] words = content.split("[\\s\\p{Punct}]+");
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
    }

    private static void saveStatisticsToFile(int totalWordCount, int uniqueWordCount,
                                             Map<String, Integer> wordFrequency, String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.println("Statistics:");
            writer.println("Total number of words: " + totalWordCount);
            writer.println("Number of unique words: " + uniqueWordCount);
            writer.println("Word frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error saving statistics to file: " + e.getMessage());
        }
    }
}
