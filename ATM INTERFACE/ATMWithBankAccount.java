import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 5th task

public class ATMWithBankAccount {
    private static final String ACCOUNTS_FILE = "accounts.txt";
    private Map<String, BankAccount> bankAccounts;

    public ATMWithBankAccount() {
        this.bankAccounts = loadBankAccounts();
    }

    public void deposit(String accountNumber, double amount) {
        if (bankAccounts.containsKey(accountNumber)) {
            BankAccount account = bankAccounts.get(accountNumber);
            account.deposit(amount);
            saveBankAccounts();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (bankAccounts.containsKey(accountNumber)) {
            BankAccount account = bankAccounts.get(accountNumber);
            account.withdraw(amount);
            saveBankAccounts();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String accountNumber) {
        if (bankAccounts.containsKey(accountNumber)) {
            BankAccount account = bankAccounts.get(accountNumber);
            System.out.println("Account balance for " + accountNumber + ": $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private Map<String, BankAccount> loadBankAccounts() {
        Map<String, BankAccount> accounts = new HashMap<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ACCOUNTS_FILE))) {
            accounts = (Map<String, BankAccount>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading bank accounts: " + e.getMessage());
        }

        return accounts;
    }

    private void saveBankAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNTS_FILE))) {
            oos.writeObject(bankAccounts);
        } catch (IOException e) {
            System.err.println("Error saving bank accounts: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ATMWithBankAccount atm = new ATMWithBankAccount();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();

        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");

        System.out.print("Choose an option (1-3): ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                atm.deposit(accountNumber, depositAmount);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                atm.withdraw(accountNumber, withdrawAmount);
                break;
            case 3:
                atm.checkBalance(accountNumber);
                break;
            default:
                System.out.println("Invalid option");
        }

        scanner.close();
    }
}
