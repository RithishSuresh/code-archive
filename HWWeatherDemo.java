public class HWWeatherDemo {
    public static void main(String[] args) {
        Weather[] weathers = new Weather[4];

        // Multilevel inheritance
        weathers[0] = new Weather("Generic Weather");
        weathers[1] = new Storm("Thunderstorm Alert");
        weathers[2] = new Thunderstorm("Severe Thunderstorm");

        // Hierarchical inheritance
        weathers[3] = new Sunshine("Sunny Day");

        System.out.println("\n--- Weather System Polymorphism Test ---");
        for (Weather w : weathers) {
            w.report();
            System.out.println();
        }
    }
}

// Base class
class Weather {
    protected String description;

    public Weather() {
        this.description = "Unknown Weather";
        System.out.println("Weather default constructor called");
    }

    public Weather(String description) {
        this.description = description;
        System.out.println("Weather parameterized constructor called: " + description);
    }

    public void report() {
        System.out.println("Weather Report: " + description);
    }
}

// Multilevel: Weather → Storm
class Storm extends Weather {
    public Storm() {
        super();
        System.out.println("Storm default constructor called");
    }

    public Storm(String description) {
        super(description);
        System.out.println("Storm parameterized constructor called");
    }

    @Override
    public void report() {
        super.report();
        System.out.println("Storm intensity: Moderate");
    }
}

// Multilevel: Storm → Thunderstorm
class Thunderstorm extends Storm {
    public Thunderstorm() {
        super();
        System.out.println("Thunderstorm default constructor called");
    }

    public Thunderstorm(String description) {
        super(description);
        System.out.println("Thunderstorm parameterized constructor called");
    }

    @Override
    public void report() {
        super.report();
        System.out.println("Thunderstorm: High winds and heavy rain expected!");
    }
}

// Hierarchical: Weather → Sunshine
class Sunshine extends Weather {
    public Sunshine() {
        super();
        System.out.println("Sunshine default constructor called");
    }

    public Sunshine(String description) {
        super(description);
        System.out.println("Sunshine parameterized constructor called");
    }

    @Override
    public void report() {
        super.report();
        System.out.println("Sunshine: Clear skies and bright sun!");
    }
}

