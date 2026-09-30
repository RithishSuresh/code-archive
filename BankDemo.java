
package Week8.Week8AssignmentHWProblem;

// Abstract class representing a bank account
abstract class BankAccount {
    protected double balance;

    // Constructor to set initial balance
    BankAccount(double balance) {
        this.balance = balance;
    }

    // Concrete method for deposit
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". New Balance: " + balance);
    }

    // Abstract method to calculate interest
    abstract void calculateInterest();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double interestRate; // e.g., 4% annual

    SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Savings Account Interest: " + interest);
        balance += interest;
        System.out.println("Balance after interest: " + balance);
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private double interestRate; // usually lower than savings, e.g., 1%

    CurrentAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Current Account Interest: " + interest);
        balance += interest;
        System.out.println("Balance after interest: " + balance);
    }
}

// Main class to test accounts
public class BankDemo {
    public static void main(String[] args) {
        // Test SavingsAccount
        SavingsAccount mySavings = new SavingsAccount(10000, 4);
        mySavings.deposit(2000);
        mySavings.calculateInterest();

        System.out.println();

        // Test CurrentAccount
        CurrentAccount myCurrent = new CurrentAccount(5000, 1);
        myCurrent.deposit(1000);
        myCurrent.calculateInterest();
    }
}
