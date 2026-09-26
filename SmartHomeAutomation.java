package Week7;
class SmartDevice {
    String name;
    SmartDevice(String name) { this.name = name; }
    void status() { System.out.println(name + " status unknown."); }
}

class SmartTV extends SmartDevice {
    SmartTV(String name) { super(name); }
    void status() { System.out.println(name + " (TV) manages channels, volume, and streaming apps."); }
    void changeChannel() { System.out.println("Changing channel on " + name); }
}

class SmartThermostat extends SmartDevice {
    SmartThermostat(String name) { super(name); }
    void status() { System.out.println(name + " (Thermostat) controls temperature, humidity, and energy saving."); }
    void adjustTemperature() { System.out.println("Adjusting temperature on " + name); }
}

class SmartSecurity extends SmartDevice {
    SmartSecurity(String name) { super(name); }
    void status() { System.out.println(name + " (Security) handles cameras, alarms, and access control."); }
    void armSystem() { System.out.println("Arming security system " + name); }
}

class SmartKitchen extends SmartDevice {
    SmartKitchen(String name) { super(name); }
    void status() { System.out.println(name + " (Kitchen) manages cooking times, temperatures, and recipes."); }
    void startCooking() { System.out.println("Starting cooking on " + name); }
}

public class SmartHomeAutomation {
    public static void main(String[] args) {
        SmartDevice[] devices = {
                new SmartTV("Living Room TV"),
                new SmartThermostat("Hallway Thermostat"),
                new SmartSecurity("Home Security"),
                new SmartKitchen("Kitchen Oven")
        };

        for (SmartDevice d : devices) {
            d.status();

            if (d instanceof SmartTV) {
                SmartTV tv = (SmartTV) d;
                tv.changeChannel();
            } else if (d instanceof SmartThermostat) {
                SmartThermostat th = (SmartThermostat) d;
                th.adjustTemperature();
            } else if (d instanceof SmartSecurity) {
                SmartSecurity sc = (SmartSecurity) d;
                sc.armSystem();
            } else if (d instanceof SmartKitchen) {
                SmartKitchen sk = (SmartKitchen) d;
                sk.startCooking();
            }

            System.out.println();
        }
    }
}

