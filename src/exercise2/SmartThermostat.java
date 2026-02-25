package exercise2;

public class SmartThermostat extends SmartDevice implements Adjustable {

    private int temperature; // 60-80

    public SmartThermostat(String deviceName) {
        super(deviceName);
        this.temperature = 70; // default
    }

    @Override
    public void turnOn() {
        System.out.println("HVAC System Starting...");
        super.turnOn(); // avoid duplicating the ON logic + global count
    }

    @Override
    public void setLevel(int level) {
        if (!isOn) {
            System.out.println("Cannot adjust: Device is OFF.");
            return;
        }

        if (level < 60 || level > 80) {
            System.out.println("Invalid temperature. Must be between 60 and 80.");
            return;
        }

        temperature = level;
        System.out.println(deviceName + " temperature set to " + temperature + "°F.");
    }

    @Override
    public void performSelfDiagnostic() {
        System.out.println(deviceName + ": Checking temperature sensors...");
    }
}

