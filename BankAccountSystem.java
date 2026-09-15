package week4;

import java.util.Random;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    public BankAccount() {
        this("Unknown", 0.0);
    }

    public BankAccount(String accountHolder) {
        this(accountHolder, 0.0);
    }

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(900000) + 100000;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder +
                ", Account Number: " + accountNumber +
                ", Balance: " + balance);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 5000);

        a1.deposit(1000);
        a2.deposit(2000);
        a3.withdraw(1000);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}
