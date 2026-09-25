package Week6;
public class LabFruitDemo {
    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Fuji");

        System.out.println("Apple Details:");
        System.out.println("Color: " + apple.color);
        System.out.println("Taste: " + apple.taste);
        System.out.println("Variety: " + apple.variety);
    }
}

class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
}

class Apple extends Fruit {
    protected String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }
}

