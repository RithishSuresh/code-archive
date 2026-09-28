class Device {
    String deviceName;
    Device(String deviceName) { this.deviceName = deviceName; }
    void status() { System.out.println(deviceName + " status unknown."); }
}

class SmartClassroom extends Device {
    SmartClassroom(String deviceName) { super(deviceName); }
    void status() { System.out.println(deviceName + " controls lighting, AC, and projectors."); }
    void adjustSettings() { System.out.println("Adjusting classroom settings for " + deviceName); }
}

class SmartLab extends Device {
    SmartLab(String deviceName) { super(deviceName); }
    void status() { System.out.println(deviceName + " manages lab equipment and safety systems."); }
    void checkSafety() { System.out.println("Checking safety systems for " + deviceName); }
}

class SmartLibrary extends Device {
    SmartLibrary(String deviceName) { super(deviceName); }
    void status() { System.out.println(deviceName + " tracks occupancy and book availability."); }
    void manageLibrary() { System.out.println("Updating library system for " + deviceName); }
}

public class SmartCampusIoTSystem {
    public static void main(String[] args) {
        Device[] devices = {
                new SmartClassroom("Classroom A"),
                new SmartLab("Chemistry Lab"),
                new SmartLibrary("Central Library")
        };

        for (Device d : devices) {
            d.status();

            if (d instanceof SmartClassroom) {
                SmartClassroom sc = (SmartClassroom) d;
                sc.adjustSettings();
            } else if (d instanceof SmartLab) {
                SmartLab sl = (SmartLab) d;
                sl.checkSafety();
            } else if (d instanceof SmartLibrary) {
                SmartLibrary slib = (SmartLibrary) d;
                slib.manageLibrary();
            }

            System.out.println();
        }
    }
}

