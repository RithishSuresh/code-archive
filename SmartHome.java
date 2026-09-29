package week7;

class SmartDevice {
    protected String name;

    public SmartDevice(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        System.out.println(name + " is now OFF.");
    }
}


class Light extends SmartDevice {
    private int brightness;

    public Light(String name, int brightness) {
        super(name);
        this.brightness = brightness;
    }

    public void adjustBrightness(int level) {
        brightness = level;
        System.out.println("Brightness of " + name + " set to " + brightness + "%");
    }
}


class Thermostat extends SmartDevice {
    private double temperature;

    public Thermostat(String name, double temperature) {
        super(name);
        this.temperature = temperature;
    }

    public void setTemperature(double temp) {
        temperature = temp;
        System.out.println("Temperature of " + name + " set to " + temperature + "°C");
    }
}


public class SmartHome {
    public static void main(String[] args) {

        SmartDevice[] devices = {
                new Light("Living Room Light", 75),
                new Thermostat("Bedroom Thermostat", 24.5),
                new SmartDevice("Generic Device")   // plain base class
        };


        for (SmartDevice device : devices) {
            device.turnOn();


            if (device instanceof Light) {
                Light l = (Light) device;
                l.adjustBrightness(50);
            } else if (device instanceof Thermostat) {
                Thermostat t = (Thermostat) device;
                t.setTemperature(22.0);
            } else {
                System.out.println(device.name + " has no extra features.");
            }

            device.turnOff();
            System.out.println();
        }
    }
}

