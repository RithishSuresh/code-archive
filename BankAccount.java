package week3;
public class BankAccount {
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited " + amount + ". New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance for " + accountHolder);
        }
    }

    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest for " + accountHolder + ": " + interest);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount.setBankName("Global Trust Bank");
        BankAccount.setInterestRate(5.0);

        BankAccount acc1 = new BankAccount("A101", "Arun", 5000);
        BankAccount acc2 = new BankAccount("A102", "Sathish", 10000);

        BankAccount.displayBankInfo();

        System.out.println("\n--- Account Details ---");
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        acc1.deposit(2000);
        acc2.withdraw(3000);

        acc1.calculateInterest();
        acc2.calculateInterest();

        System.out.println("\nTotal Accounts (via static method): " + BankAccount.getTotalAccounts());

        acc1.displayBankInfo();
        BankAccount.displayBankInfo();
    }
}

