import java.util.HashMap;
import java.util.Map;

// 1st task

public class ATM {
    private Map<String, Double> accountBalances;

    public ATM() {
        this.accountBalances = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (!accountBalances.containsKey(accountNumber)) {
            accountBalances.put(accountNumber, initialBalance);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    public double checkBalance(String accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            return accountBalances.get(accountNumber);
        } else {
            System.out.println("Account not found.");
            return -1; // Indicates account not found
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            double newBalance = currentBalance + amount;
            accountBalances.put(accountNumber, newBalance);
            System.out.println("Deposit successful. New balance: " + newBalance);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double currentBalance = accountBalances.get(accountNumber);
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                accountBalances.put(accountNumber, newBalance);
                System.out.println("Withdrawal successful. New balance: " + newBalance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        if (accountBalances.containsKey(fromAccount) && accountBalances.containsKey(toAccount)) {
            double fromBalance = accountBalances.get(fromAccount);
            if (fromBalance >= amount) {
                double toBalance = accountBalances.get(toAccount);
                accountBalances.put(fromAccount, fromBalance - amount);
                accountBalances.put(toAccount, toBalance + amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient funds for transfer.");
            }
        } else {
            System.out.println("One or more accounts not found.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();

        // Example: Creating accounts, checking balance, depositing, withdrawing, and transferring
        atm.createAccount("123456", 1000.0);
        atm.createAccount("789012", 500.0);

        System.out.println("Balance for account 123456: $" + atm.checkBalance("123456"));

        atm.deposit("123456", 200.0);
        atm.withdraw("123456", 150.0);

        System.out.println("Balance for account 789012: $" + atm.checkBalance("789012"));

        atm.transfer("123456", "789012", 100.0);
        System.out.println("Balance for account 123456: $" + atm.checkBalance("123456"));
        System.out.println("Balance for account 789012: $" + atm.checkBalance("789012"));
    }
}

