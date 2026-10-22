package APP5;
// Abstract class with an abstract method
abstract class BankAccount {
    String accountHolder;

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // All account types must implement this method
    abstract void calculateInterest();
}

// Savings Account with its own interest calculation
class SavingsAccount extends BankAccount {
    SavingsAccount(String accountHolder) { super(accountHolder); }
    void calculateInterest() {
        System.out.println("Savings Account Interest: 4% annually for " + accountHolder);
    }
}

// Current Account with its own interest calculation
class CurrentAccount extends BankAccount {
    CurrentAccount(String accountHolder) { super(accountHolder); }
    void calculateInterest() {
        System.out.println("Current Account Interest: 0% for " + accountHolder);
    }
}

// Loan Account with its own interest calculation
class LoanAccount extends BankAccount {
    LoanAccount(String accountHolder) { super(accountHolder); }
    void calculateInterest() {
        System.out.println("Loan Account Interest: 10% annually for " + accountHolder);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Creating objects of different account types
        BankAccount s = new SavingsAccount("Prakash");
        BankAccount c = new CurrentAccount("Barath");
        BankAccount l = new LoanAccount("Sanjay");

        // Polymorphism: same method behaves differently
        s.calculateInterest();
        c.calculateInterest();
        l.calculateInterest();
    }
}

