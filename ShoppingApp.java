package week3;
import java.util.*;

class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    static int totalProducts = 0;
    static Set<String> categories = new HashSet<>();

    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
        categories.add(category);
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    public void reduceStock(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
        }
    }

    public void increaseStock(int quantity) {
        stockQuantity += quantity;
    }

    public void displayProduct() {
        System.out.printf("ID: %s | Name: %s | Price: %.2f | Category: %s | Stock: %d\n",
                productId, productName, price, category, stockQuantity);
    }

    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p.getProductId().equalsIgnoreCase(productId)) return p;
        }
        return null;
    }

    public static List<Product> getProductsByCategory(Product[] products, String category) {
        List<Product> list = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) list.add(p);
        }
        return list;
    }
}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();
    private double cartTotal;

    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cartTotal = 0;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getStockQuantity() >= quantity) {
            products.add(product);
            quantities.add(quantity);
            product.reduceStock(quantity);
            calculateTotal();
            System.out.println(quantity + " x " + product.getProductName() + " added to cart.");
        } else {
            System.out.println("Not enough stock available!");
        }
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equalsIgnoreCase(productId)) {
                Product p = products.get(i);
                int qty = quantities.get(i);
                p.increaseStock(qty);
                products.remove(i);
                quantities.remove(i);
                calculateTotal();
                System.out.println("Removed product " + productId + " from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public void calculateTotal() {
        cartTotal = 0;
        for (int i = 0; i < products.size(); i++) {
            cartTotal += products.get(i).getPrice() * quantities.get(i);
        }
    }

    public void displayCart() {
        System.out.println("\n--- Shopping Cart for " + customerName + " ---");
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%s (x%d) - %.2f\n",
                    products.get(i).getProductName(),
                    quantities.get(i),
                    products.get(i).getPrice() * quantities.get(i));
        }
        System.out.printf("Cart Total: %.2f\n", cartTotal);
    }

    public void checkout() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty. Cannot checkout.");
        } else {
            displayCart();
            System.out.println("Checkout successful! Thank you for shopping.");
            products.clear();
            quantities.clear();
            cartTotal = 0;
        }
    }
}

public class ShoppingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
                new Product("P101", "Laptop", 55000, "Electronics", 5),
                new Product("P102", "Smartphone", 20000, "Electronics", 10),
                new Product("P103", "Headphones", 1500, "Electronics", 15),
                new Product("P104", "Shirt", 800, "Clothing", 20),
                new Product("P105", "Jeans", 1200, "Clothing", 18),
                new Product("P106", "Shoes", 2500, "Clothing", 12),
                new Product("P107", "Novel", 400, "Books", 30),
                new Product("P108", "Notebook", 100, "Books", 40),
                new Product("P109", "Mixer Grinder", 3500, "Home Appliances", 7),
                new Product("P110", "Refrigerator", 28000, "Home Appliances", 3)
        };

        ShoppingCart cart = new ShoppingCart("C001", "Santhosh");

        int choice;
        do {
            System.out.println("\n===== ONLINE SHOPPING SYSTEM =====");
            System.out.println("1. View All Products");
            System.out.println("2. Search Product by ID");
            System.out.println("3. View Products by Category");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. Remove Product from Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Product p : products) p.displayProduct();
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    String pid = sc.nextLine();
                    Product found = Product.findProductById(products, pid);
                    if (found != null) found.displayProduct();
                    else System.out.println("Product not found!");
                    break;
                case 3:
                    System.out.print("Enter Category: ");
                    String cat = sc.nextLine();
                    List<Product> list = Product.getProductsByCategory(products, cat);
                    if (list.isEmpty()) System.out.println("No products in this category.");
                    else for (Product p : list) p.displayProduct();
                    break;
                case 4:
                    System.out.print("Enter Product ID: ");
                    String addId = sc.nextLine();
                    Product addProd = Product.findProductById(products, addId);
                    if (addProd != null) {
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        cart.addProduct(addProd, qty);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Product ID to Remove: ");
                    String remId = sc.nextLine();
                    cart.removeProduct(remId);
                    break;
                case 6:
                    cart.displayCart();
                    break;
                case 7:
                    cart.checkout();
                    break;
                case 8:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 8);

        sc.close();
    }
}

