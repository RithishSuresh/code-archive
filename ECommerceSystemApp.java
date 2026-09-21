import java.time.LocalDateTime;
import java.util.*;

public class ECommerceSystemApp {
    public static void main(String[] args) {
        // Create products
        Product laptop = Product.createElectronics("P001","Laptop","Electronics","BrandA",1200.0,2.5,new String[]{"Touchscreen","WiFi"},Map.of("CPU","i7","RAM","16GB"));
        Product tshirt = Product.createClothing("P002","T-Shirt","Clothing","BrandB",25.0,0.3,new String[]{"Cotton","Slim Fit"},Map.of("Size","M","Color","Blue"));
        Product book = Product.createBooks("P003","Java Programming","Books","BrandC",50.0,0.5,new String[]{"Programming Guide"},Map.of("Pages","500","Language","English"));

        // Create customers
        Customer cust1 = new Customer("C001","alice@mail.com","Alice","1234567890","EN","2025-09-12");
        Customer cust2 = new Customer("C002","bob@mail.com","Bob","0987654321","EN","2025-09-10");

        // Create shopping carts
        ShoppingCart cart1 = new ShoppingCart("Cart001",cust1.getCustomerId());
        ShoppingCart cart2 = new ShoppingCart("Cart002",cust2.getCustomerId());

        // Add items to carts
        cart1.addItem(laptop,1);
        cart1.addItem(book,2);

        cart2.addItem(tshirt,3);

        // Create orders
        Order order1 = new Order("O001",LocalDateTime.now(),cart1);
        Order order2 = new Order("O002",LocalDateTime.now(),cart2);

        // Process orders
        PaymentProcessor pp = new PaymentProcessor("PP001","SEC123");
        ECommerceSystem.processOrder(order1,cust1,pp);
        ECommerceSystem.processOrder(order2,cust2,pp);

        // Display cart summaries
        System.out.println(cart1.getCartSummary());
        System.out.println(cart2.getCartSummary());

        // Display public customer profile
        System.out.println(cust1.getPublicProfile());
        System.out.println(cust2.getPublicProfile());

        // Tax calculation
        System.out.println("Laptop tax in US: "+laptop.calculateTax("US"));
    }

    public static final class Product {
        private final String productId,name,category,manufacturer;
        private final double basePrice,weight;
        private final String[] features;
        private final Map<String,String> specifications;

        private Product(String productId,String name,String category,String manufacturer,double basePrice,double weight,String[] features,Map<String,String> specifications){
            this.productId=productId;
            this.name=name;
            this.category=category;
            this.manufacturer=manufacturer;
            this.basePrice=basePrice;
            this.weight=weight;
            this.features=Arrays.copyOf(features,features.length);
            this.specifications=new HashMap<>(specifications);
        }

        public static Product createElectronics(String id,String name,String category,String manufacturer,double price,double weight,String[] features,Map<String,String> specs){
            return new Product(id,name,category,manufacturer,price,weight,features,specs);
        }
        public static Product createClothing(String id,String name,String category,String manufacturer,double price,double weight,String[] features,Map<String,String> specs){
            return new Product(id,name,category,manufacturer,price,weight,features,specs);
        }
        public static Product createBooks(String id,String name,String category,String manufacturer,double price,double weight,String[] features,Map<String,String> specs){
            return new Product(id,name,category,manufacturer,price,weight,features,specs);
        }

        public String getProductId(){return productId;}
        public String getName(){return name;}
        public String getCategory(){return category;}
        public String getManufacturer(){return manufacturer;}
        public double getBasePrice(){return basePrice;}
        public double getWeight(){return weight;}
        public String[] getFeatures(){return Arrays.copyOf(features,features.length);}
        public Map<String,String> getSpecifications(){return new HashMap<>(specifications);}

        public final double calculateTax(String region){
            if(region.equalsIgnoreCase("US")) return basePrice*0.07;
            else if(region.equalsIgnoreCase("EU")) return basePrice*0.2;
            else return basePrice*0.1;
        }
    }

    public static class Customer {
        private final String customerId,email,accountCreationDate;
        private String name,phoneNumber,preferredLanguage;

        public Customer(String customerId,String email,String name,String phoneNumber,String preferredLanguage,String accountCreationDate){
            this.customerId=customerId;
            this.email=email;
            this.name=name;
            this.phoneNumber=phoneNumber;
            this.preferredLanguage=preferredLanguage;
            this.accountCreationDate=accountCreationDate;
        }

        String getCreditRating(){return "A+";} // internal use

        public String getPublicProfile(){return "Name:"+name+", Email:"+email;}

        public String getCustomerId(){return customerId;}
        public String getEmail(){return email;}
        public String getName(){return name;}
        public void setName(String name){this.name=name;}
        public String getPhoneNumber(){return phoneNumber;}
        public void setPhoneNumber(String phone){this.phoneNumber=phone;}
        public String getPreferredLanguage(){return preferredLanguage;}
        public void setPreferredLanguage(String lang){this.preferredLanguage=lang;}
        public String getAccountCreationDate(){return accountCreationDate;}
    }

    public static class ShoppingCart {
        private final String cartId,customerId;
        private final List<Object> items=new ArrayList<>();
        private double totalAmount=0;
        private int itemCount=0;

        public ShoppingCart(String cartId,String customerId){
            this.cartId=cartId;
            this.customerId=customerId;
        }

        public boolean addItem(Object product,int quantity){
            if(product instanceof Product && quantity>0){
                for(int i=0;i<quantity;i++) items.add(product);
                totalAmount+=((Product)product).getBasePrice()*quantity;
                itemCount+=quantity;
                return true;
            }
            return false;
        }

        private double calculateDiscount(){
            if(itemCount>5) return totalAmount*0.1;
            return 0;
        }

        String getCartSummary(){
            return "CartID:"+cartId+", Customer:"+customerId+", Items:"+itemCount+", Total:"+totalAmount+", Discount:"+calculateDiscount();
        }
    }

    public static final class Order {
        private final String orderId;
        private final LocalDateTime orderTime;
        private final ShoppingCart cart;

        public Order(String orderId, LocalDateTime orderTime, ShoppingCart cart){
            this.orderId=orderId;
            this.orderTime=orderTime;
            this.cart=cart;
        }

        public String getOrderId(){return orderId;}
        public LocalDateTime getOrderTime(){return orderTime;}
        public ShoppingCart getCart(){return cart;}
    }

    public static final class PaymentProcessor {
        private final String processorId,securityKey;
        public PaymentProcessor(String processorId,String key){this.processorId=processorId;this.securityKey=key;}
        public String getProcessorId(){return processorId;}
        public String getSecurityKey(){return securityKey;}
    }

    public static final class ShippingCalculator {
        private final Map<String,Double> shippingRates;
        public ShippingCalculator(Map<String,Double> rates){this.shippingRates=new HashMap<>(rates);}
        public double calculateShipping(String region,double weight){
            return shippingRates.getOrDefault(region,5.0)*weight;
        }
    }

    public static final class ECommerceSystem {
        private static final Map<String,Object> productCatalog=new HashMap<>();
        public static boolean processOrder(Order order,Customer customer,PaymentProcessor processor){
            if(order==null || customer==null || processor==null) return false;
            // simple processing logic
            productCatalog.put(order.getOrderId(),order);
            System.out.println("Processed order "+order.getOrderId()+" for customer "+customer.getCustomerId()+" using processor "+processor.getProcessorId());
            return true;
        }
    }
}
