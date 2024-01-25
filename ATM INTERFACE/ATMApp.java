// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.GridPane;
// import javafx.stage.Stage;

// 2nd task

// public class ATMApp extends Application {
//     private TextField accountNumberField;
//     private PasswordField pinField;
//     private TextField amountField;
//     private TextArea transactionArea;

//     private ATM atm;

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         atm = new ATM();

//         primaryStage.setTitle("ATM Machine");

//         GridPane grid = new GridPane();
//         grid.setAlignment(javafx.geometry.Pos.CENTER);
//         grid.setHgap(10);
//         grid.setVgap(10);
//         grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));

//         accountNumberField = new TextField();
//         accountNumberField.setPromptText("Account Number");
//         grid.add(accountNumberField, 0, 0);

//         pinField = new PasswordField();
//         pinField.setPromptText("PIN");
//         grid.add(pinField, 0, 1);

//         Button loginButton = new Button("Login");
//         loginButton.setOnAction(e -> loginButtonClicked());
//         grid.add(loginButton, 1, 1);

//         amountField = new TextField();
//         amountField.setPromptText("Amount");
//         grid.add(amountField, 0, 2);

//         Button depositButton = new Button("Deposit");
//         depositButton.setOnAction(e -> depositButtonClicked());
//         grid.add(depositButton, 1, 2);

//         Button withdrawButton = new Button("Withdraw");
//         withdrawButton.setOnAction(e -> withdrawButtonClicked());
//         grid.add(withdrawButton, 2, 2);

//         Button checkBalanceButton = new Button("Check Balance");
//         checkBalanceButton.setOnAction(e -> checkBalanceButtonClicked());
//         grid.add(checkBalanceButton, 1, 3);

//         transactionArea = new TextArea();
//         transactionArea.setEditable(false);
//         grid.add(transactionArea, 0, 4, 3, 1);

//         Scene scene = new Scene(grid, 400, 300);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     private void loginButtonClicked() {
//         String accountNumber = accountNumberField.getText();
//         String pin = pinField.getText();
//         // Add authentication logic here (not implemented in this example)
//         // For simplicity, assume login is successful without validation
//         transactionArea.appendText("Login successful.\n");
//     }

//     private void depositButtonClicked() {
//         String accountNumber = accountNumberField.getText();
//         double amount = Double.parseDouble(amountField.getText());
//         atm.deposit(accountNumber, amount);
//         transactionArea.appendText("Deposit of $" + amount + " successful.\n");
//     }

//     private void withdrawButtonClicked() {
//         String accountNumber = accountNumberField.getText();
//         double amount = Double.parseDouble(amountField.getText());
//         atm.withdraw(accountNumber, amount);
//         transactionArea.appendText("Withdrawal of $" + amount + " successful.\n");
//     }

//     private void checkBalanceButtonClicked() {
//         String accountNumber = accountNumberField.getText();
//         double balance = atm.checkBalance(accountNumber);
//         if (balance != -1) {
//             transactionArea.appendText("Account balance: $" + balance + "\n");
//         }
//     }
// }
