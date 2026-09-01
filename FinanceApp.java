package week3;
import java.util.*;

class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    private static int totalAccounts = 0;
    private static String bankName;
    private static int accountCounter = 1;

    public PersonalAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = initialDeposit;
        this.totalIncome = initialDeposit;
        this.totalExpenses = 0;
        totalAccounts++;
    }

    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println(accountHolderName + " received income: " + description + " (+₹" + amount + ")");
        } else {
            System.out.println("Invalid income amount!");
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println(accountHolderName + " spent on: " + description + " (-₹" + amount + ")");
        } else {
            System.out.println("Invalid or insufficient balance for expense!");
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Bank Name      : " + bankName);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: ₹" + currentBalance);
        System.out.println("Total Income   : ₹" + totalIncome);
        System.out.println("Total Expenses : ₹" + totalExpenses);
        System.out.println("Total Savings  : ₹" + calculateSavings());
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", accountCounter++);
    }
}

public class FinanceApp {
    public static void main(String[] args) {
        PersonalAccount.setBankName("Future Bank of India");

        PersonalAccount acc1 = new PersonalAccount("Rahul Sharma", 10000);
        PersonalAccount acc2 = new PersonalAccount("Ananya Singh", 5000);
        PersonalAccount acc3 = new PersonalAccount("Vikram Kumar", 2000);

        acc1.addIncome(5000, "Salary");
        acc1.addExpense(2000, "Groceries");

        acc2.addIncome(2000, "Freelance Work");
        acc2.addExpense(1000, "Electricity Bill");

        acc3.addIncome(1000, "Part-time Job");
        acc3.addExpense(500, "Books");

        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        System.out.println("\nBank Name (shared across all accounts): Future Bank of India");
        System.out.println("Total Accounts Created: " + PersonalAccount.getTotalAccounts());
    }
}

