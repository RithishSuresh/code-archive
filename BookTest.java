// Book class
class Book {
    String title;
    String author;
    double price;

    // Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to calculate discounted price
    double discountedPrice(double discountPercent) {
        return price - (price * discountPercent / 100);
    }
}

// Main class
public class BookTest {
    public static void main(String[] args) {
        // Create Book object
        Book book1 = new Book("Java Programming", "James Gosling", 500.0);

        // Test discountedPrice method
        double discount = 10; // 10% discount
        double finalPrice = book1.discountedPrice(discount);

        // Display results
        System.out.println("Book Title: " + book1.title);
        System.out.println("Author: " + book1.author);
        System.out.println("Original Price: ₹" + book1.price);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Price after Discount: ₹" + finalPrice);
    }
}
