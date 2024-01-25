import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount5 {

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

        System.out.println("\nNumber of words: " + wordCount);

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
        // Split the content into words using space or punctuation as delimiters
        String[] words = content.split("[\\s\\p{Punct}]+");
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
