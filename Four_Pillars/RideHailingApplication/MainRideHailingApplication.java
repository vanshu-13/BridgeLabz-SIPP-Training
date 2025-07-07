import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRideHailingApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Enter number of vehicles:");
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter vehicle type (1-Car, 2-Bike, 3-Auto):");
            int type = s.nextInt();
            s.nextLine();

            System.out.println("Enter vehicle ID:");
            String vehicleId = s.nextLine();

            System.out.println("Enter driver name:");
            String driverName = s.nextLine();

            System.out.println("Enter rate per km:");
            double ratePerKm = s.nextDouble();
            s.nextLine();

            Vehicle vehicle = null;
            switch (type) {
                case 1:
                    vehicle = new Car(vehicleId, driverName, ratePerKm);
                    break;
                case 2:
                    vehicle = new Bike(vehicleId, driverName, ratePerKm);
                    break;
                case 3:
                    vehicle = new Auto(vehicleId, driverName, ratePerKm);
                    break;
                default:
                    System.out.println("Invalid vehicle type.");
                    i--;
                    continue;
            }
            vehicles.add(vehicle);
        }

        System.out.println("\nVehicle Details and Fare Calculation:");
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            double distance = 10.0; // example distance
            System.out.println("Fare for 10 km: " + v.calculateFare(distance));
            if (v instanceof GPS) {
                GPS gps = (GPS) v;
                System.out.println("Current Location: " + gps.getCurrentLocation());
                gps.updateLocation("New Location");
                System.out.println("Updated Location: " + gps.getCurrentLocation());
            }
            System.out.println("-----------------------");
        }

        // Do not close Scanner s as per instructions
    }
}
