// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.VBox;
// import javafx.stage.FileChooser;
// import javafx.stage.Stage;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;

// // 10 task

// public class WordCountGUI {

//     private final Map<String, Integer> wordFrequency = new HashMap<>();

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Word Count Application");

//         TextArea textArea = new TextArea();
//         textArea.setWrapText(true);
//         textArea.setPromptText("Enter text or load a file...");

//         Label totalWordsLabel = new Label("Total Words: 0");
//         Label uniqueWordsLabel = new Label("Unique Words: 0");

//         Button analyzeButton = new Button("Analyze");
//         analyzeButton.setOnAction(e -> analyzeWords(textArea.getText(), totalWordsLabel, uniqueWordsLabel));

//         Button loadFileButton = new Button("Load File");
//         loadFileButton.setOnAction(e -> loadFile(textArea));

//         Button saveStatsButton = new Button("Save Statistics");
//         saveStatsButton.setOnAction(e -> saveStatisticsToFile(totalWordsLabel.getText(), uniqueWordsLabel.getText()));

//         VBox layout = new VBox(10);
//         layout.getChildren().addAll(textArea, totalWordsLabel, uniqueWordsLabel, analyzeButton, loadFileButton, saveStatsButton);

//         Scene scene = new Scene(layout, 400, 300);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     private void analyzeWords(String content, Label totalWordsLabel, Label uniqueWordsLabel) {
//         wordFrequency.clear();
//         int totalWordCount = 0;
//         int uniqueWordCount = 0;

//         // Split the content into words using space or punctuation as delimiters
//         String[] words = content.split("[\\s\\p{Punct}]+");
//         for (String word : words) {
//             if (!word.isEmpty()) {
//                 word = word.toLowerCase();
//                 wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
//                 totalWordCount++;
//             }
//         }

//         uniqueWordCount = wordFrequency.size();

//         totalWordsLabel.setText("Total Words: " + totalWordCount);
//         uniqueWordsLabel.setText("Unique Words: " + uniqueWordCount);
//     }

//     private void loadFile(TextArea textArea) {
//         FileChooser fileChooser = new FileChooser();
//         fileChooser.setTitle("Open Text File");
//         File file = fileChooser.showOpenDialog(null);

//         if (file != null) {
//             try (Scanner scanner = new Scanner(file)) {
//                 StringBuilder content = new StringBuilder();
//                 while (scanner.hasNextLine()) {
//                     content.append(scanner.nextLine()).append("\n");
//                 }
//                 textArea.setText(content.toString());
//             } catch (FileNotFoundException e) {
//                 e.printStackTrace();
//             }
//         }
//     }

//     private void saveStatisticsToFile(String totalWords, String uniqueWords) {
//         FileChooser fileChooser = new FileChooser();
//         fileChooser.setTitle("Save Statistics");
//         File file = fileChooser.showSaveDialog(null);

//         if (file != null) {
//             try {
//                 try (PrintWriter writer = new PrintWriter(file)) {
//                     writer.println("Statistics:");
//                     writer.println(totalWords);
//                     writer.println(uniqueWords);
//                     writer.println("Word frequency:");
//                     for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
//                         writer.println(entry.getKey() + ": " + entry.getValue() + " times");
//                     }
//                 }
//             } catch (FileNotFoundException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
