import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCount7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String content = "";
        int wordCount = 0;

        switch (option) {
            case 1:
                System.out.println("Enter your text:");
                content = scanner.nextLine();
                wordCount = countWords(content);
                break;
            case 2:
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                content = readFromFile(filePath);
                wordCount = countWords(content);
                break;
            default:
                System.out.println("Invalid option");
        }

        System.out.println("Content stored in a string:");
        System.out.println(content);

        System.out.println("\nTotal number of words (excluding common words): " + wordCount);

        // Save to a file if user wants to
        System.out.println("\nDo you want to save the content to a file? (yes/no)");
        String saveOption = scanner.nextLine().toLowerCase();

        if (saveOption.equals("yes")) {
            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine();
            saveToFile(content, fileName);
            System.out.println("Content saved to file: " + fileName);
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

    private static int countWords(String content) {
        int count = 0;

        // Define common words or stop words
        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("and");
        // Add more stop words as needed

        // Split the content into words using space or punctuation as delimiters
        String[] words = content.split("[\\s\\p{Punct}]+");
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    private static void saveToFile(String content, String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.print(content);
        } catch (FileNotFoundException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
}
