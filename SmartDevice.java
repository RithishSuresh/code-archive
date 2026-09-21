import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

public class SmartDevice {
    // Read-only properties
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;

    // Write-only properties
    private int hashedEncryptionKey;
    private int hashedAdminPassword;

    // Read-write properties
    private String deviceName;
    private boolean isEnabled;

    // Computed read-only
    private final LocalDateTime startupTime;

    // Constructor
    public SmartDevice(String deviceName) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now();
        this.serialNumber = UUID.randomUUID().toString();
        this.startupTime = LocalDateTime.now();
        this.deviceName = deviceName;
        this.isEnabled = true;
    }

    // Read-only property getters
    public String getDeviceId() {
        return deviceId;
    }

    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public long getUptime() {
        return Duration.between(startupTime, LocalDateTime.now()).toSeconds();
    }

    public int getDeviceAge() {
        return LocalDateTime.now().getYear() - manufacturingDate.getYear();
    }

    // Write-only property setters
    public void setEncryptionKey(String key) {
        if (key == null || key.length() < 8) {
            System.out.println("Encryption key too weak.");
            return;
        }
        hashedEncryptionKey = key.hashCode();
    }

    public void setAdminPassword(String password) {
        if (password == null || password.length() < 6) {
            System.out.println("Password too weak.");
            return;
        }
        hashedAdminPassword = password.hashCode();
    }

    // Write-only validators
    public boolean validateEncryptionKey(String key) {
        return hashedEncryptionKey == key.hashCode();
    }

    public boolean validateAdminPassword(String password) {
        return hashedAdminPassword == password.hashCode();
    }

    // Read-write properties
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String name) {
        this.deviceName = name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    // Utility methods
    public Map<String, String> getPropertyInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("deviceId", "read-only");
        info.put("manufacturingDate", "read-only");
        info.put("serialNumber", "read-only");
        info.put("encryptionKey", "write-only");
        info.put("adminPassword", "write-only");
        info.put("deviceName", "read-write");
        info.put("isEnabled", "read-write");
        info.put("uptime", "read-only, computed");
        info.put("deviceAge", "read-only, computed");
        return info;
    }

    public void resetDevice() {
        hashedEncryptionKey = 0;
        hashedAdminPassword = 0;
        deviceName = "DefaultDevice";
        isEnabled = false;
    }

    // Main method to demonstrate
    public static void main(String[] args) throws InterruptedException {
        SmartDevice dev1 = new SmartDevice("DeviceOne");

        // Read-only demonstration
        System.out.println("Device ID: " + dev1.getDeviceId());
        System.out.println("Serial Number: " + dev1.getSerialNumber());
        System.out.println("Device Age: " + dev1.getDeviceAge());
        System.out.println("Uptime (seconds): " + dev1.getUptime());

        // Write-only demonstration
        dev1.setEncryptionKey("StrongKey123");
        dev1.setAdminPassword("AdminPass456");
        System.out.println("Encryption Key valid? " + dev1.validateEncryptionKey("StrongKey123"));
        System.out.println("Admin Password valid? " + dev1.validateAdminPassword("AdminPass456"));

        // Read-write demonstration
        System.out.println("Device Name: " + dev1.getDeviceName());
        dev1.setDeviceName("NewDeviceOne");
        System.out.println("Updated Device Name: " + dev1.getDeviceName());

        System.out.println("Is Enabled: " + dev1.isEnabled());
        dev1.setEnabled(false);
        System.out.println("Updated Is Enabled: " + dev1.isEnabled());

        // Multiple devices independence
        SmartDevice dev2 = new SmartDevice("DeviceTwo");
        dev2.setEncryptionKey("KeyTwo");
        dev2.setAdminPassword("PasswordTwo");
        System.out.println("Dev1 encryption valid for Dev2? " + dev2.validateEncryptionKey("StrongKey123"));

        // Reset device demonstration
        dev1.resetDevice();
        System.out.println("Dev1 after reset, Name: " + dev1.getDeviceName() + ", Enabled: " + dev1.isEnabled());
    }
}

