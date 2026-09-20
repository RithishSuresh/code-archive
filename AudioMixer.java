package week4;

public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    public AudioMixer() {
        this("StandardMix-8", 8, false);
    }

    public AudioMixer(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false);
    }

    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
    }

    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;
        System.out.println("Constructor executed: " + mixerModel);
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        AudioMixer mixer1 = new AudioMixer();
        AudioMixer mixer2 = new AudioMixer("ProMix-12", 12);
        AudioMixer mixer3 = new AudioMixer("LiveMix-16", 16, true);
        AudioMixer mixer4 = new AudioMixer("UltraMix-24", 24, true, 150.0);

        mixer1.connectDevice("Microphone");
        mixer1.connectDevice("Keyboard");

        mixer2.connectDevice("Electric Guitar");

        mixer3.connectDevice("Drum Machine");
        mixer3.connectDevice("Bass Guitar");
        mixer3.connectDevice("Laptop");

        mixer4.connectDevice("DJ Controller");
        mixer4.connectDevice("Synthesizer");
        mixer4.connectDevice("Vocal Processor");
        mixer4.connectDevice("Sampler");

        mixer1.displayMixerStatus();
        mixer2.displayMixerStatus();
        mixer3.displayMixerStatus();
        mixer4.displayMixerStatus();

        System.out.println("\nNote: Constructor chaining follows order → No-arg → 2-param → 3-param → Full constructor.");
    }
}
