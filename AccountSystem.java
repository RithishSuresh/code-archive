package week3;
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    private static int totalAccounts = 0;
    private static int accountCounter = 0;

    public Account(String accountHolderName, double initialDeposit) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.println(amount + " withdrawn successfully.");
    }

    public double checkBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        accountCounter++;
        return String.format("ACC%03d", accountCounter);
    }

    public void displayAccountInfo() {
        System.out.println("--------------- Account Info ---------------");
        System.out.println("Account Number   : " + accountNumber);
        System.out.println("Account Holder   : " + accountHolderName);
        System.out.println("Balance          : " + balance);
        System.out.println("--------------------------------------------");
    }
}

public class AccountSystem {
    public static void main(String[] args) {
        Account[] accounts = new Account[3];
        accounts[0] = new Account("Alice", 1000);
        accounts[1] = new Account("Bob", 500);
        accounts[2] = new Account("Charlie", 2000);

        for (Account acc : accounts) {
            acc.displayAccountInfo();
        }

        accounts[0].deposit(500);
        accounts[1].withdraw(200);
        accounts[2].withdraw(2500);

        System.out.println("Alice's Balance   : " + accounts[0].checkBalance());
        System.out.println("Bob's Balance     : " + accounts[1].checkBalance());
        System.out.println("Charlie's Balance : " + accounts[2].checkBalance());

        System.out.println("\nTotal Accounts Created: " + Account.getTotalAccounts());
    }
}

