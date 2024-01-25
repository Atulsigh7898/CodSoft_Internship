import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 3rd task

public class ATMOperations {
    private static final String ACCOUNTS_FILE = "accounts.txt";

    private Map<String, Double> accountBalances;

    public ATMOperations() {
        this.accountBalances = loadAccounts();
    }

    public void withdraw(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                accountBalances.put(accountNumber, newBalance);
                saveAccounts(accountBalances);
                System.out.println("Withdrawal successful. New balance: $" + newBalance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            double newBalance = currentBalance + amount;
            accountBalances.put(accountNumber, newBalance);
            saveAccounts(accountBalances);
            System.out.println("Deposit successful. New balance: $" + newBalance);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            double balance = accountBalances.get(accountNumber);
            System.out.println("Account balance: $" + balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    private Map<String, Double> loadAccounts() {
        Map<String, Double> accounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String accountNumber = parts[0];
                    double balance = Double.parseDouble(parts[1]);
                    accounts.put(accountNumber, balance);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading accounts: " + e.getMessage());
        }

        return accounts;
    }

    private void saveAccounts(Map<String, Double> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ACCOUNTS_FILE))) {
            for (Map.Entry<String, Double> entry : accounts.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Error saving accounts: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ATMOperations atm = new ATMOperations();

        // Example: Deposit, Withdraw, and Check Balance
        atm.deposit("123456", 500.0);
        atm.checkBalance("123456");
        atm.withdraw("123456", 200.0);
        atm.checkBalance("123456");
    }
}
