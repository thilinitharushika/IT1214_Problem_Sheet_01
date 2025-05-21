class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getOwnerName() { return ownerName; }
    public int getHoursParked() { return hoursParked; }

    public String toString() {
        return "License: " + licensePlate + ", Owner: " + ownerName + ", Hours: " + hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles = new Vehicle[5];
    private int count = 0;

    public void parkVehicle(Vehicle v) {
        if (count < 5) {
            vehicles[count++] = v;
        } else {
            System.out.println("Parking Lot Full.");
        }
    }

    public void removeVehicle(String licensePlate) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                for (int j = i; j < count - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[--count] = null;
                return;
            }
        }
        System.out.println("Vehicle with license " + licensePlate + " not found.");
    }

    public void displayAllVehicles() {
        for (int i = 0; i < count; i++) {
            System.out.println(vehicles[i]);
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        lot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        lot.removeVehicle("XYZ789");

        lot.displayAllVehicles();
    }
}
