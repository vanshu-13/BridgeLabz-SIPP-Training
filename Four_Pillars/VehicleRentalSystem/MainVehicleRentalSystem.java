import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainVehicleRentalSystem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Enter number of vehicles:");
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter vehicle type (1-Car, 2-Bike, 3-Truck):");
            int type = s.nextInt();
            s.nextLine();

            System.out.println("Enter vehicle number:");
            String vehicleNumber = s.nextLine();

            System.out.println("Enter vehicle type description:");
            String vehicleType = s.nextLine();

            System.out.println("Enter rental rate:");
            double rentalRate = s.nextDouble();
            s.nextLine();

            System.out.println("Enter insurance cost:");
            double insuranceCost = s.nextDouble();
            s.nextLine();

            Vehicle vehicle = null;
            switch (type) {
                case 1:
                    vehicle = new Car(vehicleNumber, vehicleType, rentalRate, insuranceCost);
                    break;
                case 2:
                    vehicle = new Bike(vehicleNumber, vehicleType, rentalRate, insuranceCost);
                    break;
                case 3:
                    vehicle = new Truck(vehicleNumber, vehicleType, rentalRate, insuranceCost);
                    break;
                default:
                    System.out.println("Invalid vehicle type.");
                    i--;
                    continue;
            }
            vehicles.add(vehicle);
        }

        System.out.println("\nVehicle Rental and Insurance Details:");
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Type: " + v.getType());
            System.out.println("Rental Cost for 5 days: " + v.calculateRentalCost(5));
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Insurance Cost: " + ins.calculateInsurance());
            }
            System.out.println("-----------------------");
        }

        // Do not close Scanner s as per instructions
    }
}
