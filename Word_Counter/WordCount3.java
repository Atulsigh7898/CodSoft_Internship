import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// task 3rd

public class WordCount3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String content = "";

        switch (option) {
            case 1:
                System.out.println("Enter your text:");
                content = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                content = readFromFile(filePath);
                break;
            default:
                System.out.println("Invalid option");
        }

        System.out.println("Content stored in a string:");
        System.out.println(content);

        String[] words = splitIntoWords(content);
        System.out.println("\nArray of words:");
        for (String word : words) {
            System.out.println(word);
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

    private static String[] splitIntoWords(String content) {
        // Split the content into words using space or punctuation as delimiters
        return content.split("[\\s\\p{Punct}]+");
    }
}
