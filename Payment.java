package Week9;
interface Discount {
    double apply(double amount);
}

public class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void processTransaction() {
        class Validator {
            boolean isValid() {
                return amount > 0;
            }
        }

        Validator validator = new Validator();
        if (!validator.isValid()) {
            System.out.println("Invalid payment amount.");
            return;
        }

        Discount discount = new Discount() {
            @Override
            public double apply(double amt) {
                return amt * 0.9; // 10% discount
            }
        };

        double finalAmount = discount.apply(amount);
        System.out.println("Payment processed. Original: " + amount + ", After Discount: " + finalAmount);
    }

    public static void main(String[] args) {
        Payment p1 = new Payment(1000);
        p1.processTransaction();

        Payment p2 = new Payment(-50);
        p2.processTransaction();
    }
}

