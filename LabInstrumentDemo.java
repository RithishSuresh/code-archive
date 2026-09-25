package Week6;
public class LabInstrumentDemo {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[3];

        instruments[0] = new Piano("Grand Piano", "Wood", 88);
        instruments[1] = new Guitar("Acoustic Guitar", "Wood", 6);
        instruments[2] = new Drum("Bass Drum", "Metal", "Large");

        for (Instrument instrument : instruments) {
            instrument.display();
            System.out.println();
        }
    }
}

class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void display() {
        System.out.println("Instrument: " + name);
        System.out.println("Material: " + material);
    }
}

class Piano extends Instrument {
    private int keys;

    public Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Keys: " + keys);
    }
}

class Guitar extends Instrument {
    private int strings;

    public Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Strings: " + strings);
    }
}

class Drum extends Instrument {
    private String size;

    public Drum(String name, String material, String size) {
        super(name, material);
        this.size = size;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Size: " + size);
    }
}

