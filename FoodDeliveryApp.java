public class FoodDeliveryApp {
    void calculateDelivery(int distance) {
        int cost = distance * 10;
        System.out.println("Basic Delivery: Distance " + distance + " km, Cost = " + cost);
    }

    void calculateDelivery(int distance, int priorityFee) {
        int cost = distance * 10 + priorityFee;
        System.out.println("Premium Delivery: Distance " + distance + " km + Priority Fee " + priorityFee + ", Cost = " + cost);
    }

    void calculateDelivery(int distance, int orders, boolean group) {
        int cost = distance * 10 - orders * 5;
        System.out.println("Group Delivery: Distance " + distance + " km with " + orders + " orders, Cost = " + cost);
    }

    void calculateDelivery(int distance, int discountPercent, int freeLimit) {
        int baseCost = distance * 10;
        int cost = baseCost > freeLimit ? 0 : baseCost - (baseCost * discountPercent / 100);
        System.out.println("Festival Delivery: Distance " + distance + " km, Discount " + discountPercent + "%, Final Cost = " + cost);
    }

    public static void main(String[] args) {
        FoodDeliveryApp fd = new FoodDeliveryApp();
        fd.calculateDelivery(5);
        fd.calculateDelivery(5, 50);
        fd.calculateDelivery(10, 3, true);
        fd.calculateDelivery(8, 20, 100);
    }
}
