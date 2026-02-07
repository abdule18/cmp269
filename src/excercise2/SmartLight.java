package excercise2;

public class SmartLight extends SmartDevice implements Adjustable {

    private int brightness; // 0-100

    public SmartLight(String deviceName) {
        super(deviceName);
        this.brightness = 0;
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    @Override
    public void setLevel(int level) {
        if (!isOn) {
            System.out.println("Cannot adjust: Device is OFF.");
            return;
        }

        if (level < 0) level = 0;
        if (level > 100) level = 100;

        brightness = level;
        System.out.println(deviceName + " brightness set to " + brightness + "%.");
    }

    @Override
    public void performSelfDiagnostic() {
        System.out.println(deviceName + ": Checking LED health...");
    }
}

