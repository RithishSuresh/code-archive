package Week8;


// Interface definition
interface PaymentGateway {
    // Declare method pay(double amount)
    void pay(double amount);

    // Declare method refund(double amount)
    void refund(double amount);
}

// Class implementing PaymentGateway using Credit Card
class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " to Credit Card");
    }
}

// Class implementing PaymentGateway using UPI
class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " to UPI");
    }
}

// Main class to test
public class PaymentTest {
    public static void main(String[] args) {
        // PaymentGateway reference -> CreditCardPayment
        PaymentGateway creditCard = new CreditCardPayment();
        creditCard.pay(2500);
        creditCard.refund(500);

        System.out.println();

        // PaymentGateway reference -> UPIPayment
        PaymentGateway upi = new UPIPayment();
        upi.pay(1500);
        upi.refund(300);
    }
}

