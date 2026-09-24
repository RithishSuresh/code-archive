package Week6;
public class HWFoodDemo {
    public static void main(String[] args) {
        Food pizza = new Pizza();
        Food soup = new Soup();

        System.out.println("Preparing Pizza:");
        pizza.prepare();

        System.out.println("\nPreparing Soup:");
        soup.prepare();
    }
}

// Abstract class defining template method
abstract class Food {
    // Template method
    public final void prepare() {
        wash();
        cook();
        serve();
    }

    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}

// Pizza class with specific steps
class Pizza extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables and dough for pizza");
    }

    @Override
    protected void cook() {
        System.out.println("Baking pizza in the oven");
    }

    @Override
    protected void serve() {
        System.out.println("Serving hot pizza with toppings");
    }
}

// Soup class with specific steps
class Soup extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables for soup");
    }

    @Override
    protected void cook() {
        System.out.println("Boiling soup on stove");
    }

    @Override
    protected void serve() {
        System.out.println("Serving soup in a bowl");
    }
}

