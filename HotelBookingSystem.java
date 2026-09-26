class HotelBookingSystem {

    void calculatePrice(String roomType, int nights) {
        int cost = nights * 1000;
        System.out.println("Standard Booking: Room " + roomType + ", Nights: " + nights + ", Cost: " + cost);
    }

    void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        int baseCost = nights * 1000;
        double cost = baseCost * seasonalMultiplier;
        System.out.println("Seasonal Booking: Room " + roomType + ", Nights: " + nights + ", Multiplier: " + seasonalMultiplier + ", Cost: " + cost);
    }

    void calculatePrice(String roomType, int nights, double corporateDiscount, boolean mealPackage) {
        int baseCost = nights * 1000;
        double cost = baseCost - corporateDiscount + (mealPackage ? 500 : 0);
        System.out.println("Corporate Booking: Room " + roomType + ", Nights: " + nights + ", Discount: " + corporateDiscount + ", Meal Package: " + (mealPackage ? "Yes" : "No") + ", Cost: " + cost);
    }

    void calculatePrice(String roomType, int nights, int guests, double decorationFee, boolean catering) {
        int baseCost = nights * 1000;
        double cost = baseCost + decorationFee + (catering ? 1000 : 0);
        System.out.println("Wedding Package: Room " + roomType + ", Nights: " + nights + ", Guests: " + guests + ", Decoration Fee: " + decorationFee + ", Catering: " + (catering ? "Yes" : "No") + ", Total Cost: " + cost);
    }

    public static void main(String[] args) {
        HotelBookingSystem hbs = new HotelBookingSystem();
        hbs.calculatePrice("Deluxe", 3);
        hbs.calculatePrice("Deluxe", 3, 1.5);
        hbs.calculatePrice("Deluxe", 3, 500, true);
        hbs.calculatePrice("Deluxe", 3, 50, 2000, true);
    }
}

