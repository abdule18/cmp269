package excercise2;

public abstract class SmartDevice implements Powerable {

    protected String deviceName;
    protected boolean isOn;

    protected static int activeDevicesCount = 0;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
        this.isOn = false; // default OFF
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            activeDevicesCount++;
            System.out.println(deviceName + " is now ON.");
        } else {
            System.out.println(deviceName + " is already ON.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            activeDevicesCount--;
            System.out.println(deviceName + " is now OFF.");
        } else {
            System.out.println(deviceName + " is already OFF.");
        }
    }

    // Abstract method each device must implement
    public abstract void performSelfDiagnostic();
}

