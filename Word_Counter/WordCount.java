import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 1st task

public class WordCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (option) {
            case 1:
                System.out.println("Enter your text:");
                String text = scanner.nextLine();
                int wordCount = countWords(text);
                System.out.println("Number of words: " + wordCount);
                break;
            case 2:
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                int fileWordCount = countWordsFromFile(filePath);
                if (fileWordCount != -1) {
                    System.out.println("Number of words in the file: " + fileWordCount);
                }
                break;
            default:
                System.out.println("Invalid option");
        }

        scanner.close();
    }

    private static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    private static int countWordsFromFile(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            StringBuilder content = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
            return countWords(content.toString());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return -1;
        }
    }
}
