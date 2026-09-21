public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    // Account Info Methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked. Cannot access balance.");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    // Security Methods
    public void setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect old PIN. Cannot change.");
        }
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked. PIN validation failed.");
            return false;
        }
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            System.out.println("Incorrect PIN.");
            return false;
        }
    }

    public void unlockAccount(int correctPin) {
        if (pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked successfully.");
        } else {
            System.out.println("Incorrect PIN. Cannot unlock.");
        }
    }

    // Transaction Methods
    public void deposit(double amount, int enteredPin) {
        if (!validatePin(enteredPin)) return;
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ". New balance: " + balance);
    }

    public void withdraw(double amount, int enteredPin) {
        if (!validatePin(enteredPin)) return;
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount + ". New balance: " + balance);
    }

    public void transfer(SecureBankAccount target, double amount, int enteredPin) {
        if (!validatePin(enteredPin)) return;
        if (amount > balance) {
            System.out.println("Insufficient funds. Transfer failed.");
            return;
        }
        balance -= amount;
        target.balance += amount;
        System.out.println("Transferred: " + amount + " to " + target.getAccountNumber());
    }

    // Private Helper Methods
    private void lockAccount() {
        isLocked = true;
        System.out.println("Account locked due to multiple failed attempts.");
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC1001", 5000);
        SecureBankAccount acc2 = new SecureBankAccount("ACC1002", 3000);

        // Direct access not allowed (will cause compilation error)
        // acc1.balance = 10000; // Not allowed

        // Set PINs
        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);

        // Deposits and withdrawals
        acc1.deposit(1000, 1234);
        acc2.withdraw(500, 5678);

        // Wrong PIN attempts
        acc1.withdraw(100, 1111);
        acc1.withdraw(100, 2222);
        acc1.withdraw(100, 3333); // Account locks after 3 wrong attempts

        // Trying operations on locked account
        acc1.deposit(500, 1234); // Should fail

        // Unlock account
        acc1.unlockAccount(1234);
        acc1.deposit(500, 1234);

        // Transfer money
        acc1.transfer(acc2, 2000, 1234);

        // Show final balances
        System.out.println(acc1.getAccountNumber() + " Balance: " + acc1.getBalance());
        System.out.println(acc2.getAccountNumber() + " Balance: " + acc2.getBalance());
    }
}
