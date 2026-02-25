package exercise2;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<SmartDevice> homeHub = new ArrayList<>();

        SmartLight livingRoom = new SmartLight("Living Room Light");
        SmartLight kitchen = new SmartLight("Kitchen Light");
        SmartThermostat hallway = new SmartThermostat("Hallway Thermostat");

        homeHub.add(livingRoom);
        homeHub.add(kitchen);
        homeHub.add(hallway);

        livingRoom.turnOn();
        hallway.turnOn();

        kitchen.setLevel(75);

        System.out.println("Active Devices Count: " + SmartDevice.activeDevicesCount);

        for (SmartDevice device : homeHub) {
            device.performSelfDiagnostic();
        }
    }
}

