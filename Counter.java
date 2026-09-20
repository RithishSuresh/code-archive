package week4;

public class Counter {
    static int count = 0;

    Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== OBJECT CREATION COUNTER ===");

        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();

        System.out.println("Number of Counter objects created: " + Counter.getCount());
    }
}

