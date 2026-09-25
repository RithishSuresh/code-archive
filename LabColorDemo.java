package Week6;
public class LabColorDemo {
    public static void main(String[] args) {
        RedColor red = new RedColor("Red", 80, "Crimson");
        red.display();
    }
}

class Color {
    protected String name;

    public Color(String name) {
        this.name = name;
        System.out.println("Color constructor called: " + name);
    }
}

class PrimaryColor extends Color {
    protected int intensity;

    public PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor called with intensity: " + intensity);
    }
}

class RedColor extends PrimaryColor {
    private String shade;

    public RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("RedColor constructor called with shade: " + shade);
    }

    public void display() {
        System.out.println("Color Name: " + name);
        System.out.println("Intensity: " + intensity);
        System.out.println("Shade: " + shade);
    }
}

