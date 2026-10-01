package Week8;

// Abstract class BankAccount
abstract class BankAccount {
    protected double balance;

    // Constructor to set balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Abstract method to be implemented by subclasses
    public abstract void calculateInterest();

    // Non-abstract method to display balance
    public void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

// Subclass SavingsAccount extends BankAccount
class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    // Implement calculateInterest() -> interest = balance * 0.04
    @Override
    public void calculateInterest() {
        double interest = balance * 0.04;
        System.out.println("Savings Account Interest: ₹" + interest);
    }
}

// Subclass CurrentAccount extends BankAccount
class CurrentAccount extends BankAccount {
    public CurrentAccount(double balance) {
        super(balance);
    }

    // Implement calculateInterest() -> interest = balance * 0.02
    @Override
    public void calculateInterest() {
        double interest = balance * 0.02;
        System.out.println("Current Account Interest: ₹" + interest);
    }
}

// Main class for testing
public class BankTest {
    public static void main(String[] args) {
        // BankAccount reference -> SavingsAccount
        BankAccount savings = new SavingsAccount(50000);
        savings.displayBalance();
        savings.calculateInterest();

        System.out.println();

        // BankAccount reference -> CurrentAccount
        BankAccount current = new CurrentAccount(80000);
        current.displayBalance();
        current.calculateInterest();
    }
}

