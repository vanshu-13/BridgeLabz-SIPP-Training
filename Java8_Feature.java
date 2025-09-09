package SmartcityandServices;

import java.util.*;
import java.util.stream.*;

interface TransportService {
    String getName();
    double getFare();
    default void printDetails() {
        System.out.println(getName() + " -> Fare: " + getFare());
    }
}

@FunctionalInterface
interface FareCalculator {
    double calculate(double distance, double rate);
}

interface EmergencyService {}

class BusService implements TransportService {
    private String name;
    private double fare;
    BusService(String name, double fare) { this.name = name; this.fare = fare; }
    public String getName() { return name; }
    public double getFare() { return fare; }
}

class TaxiService implements TransportService {
    private String name;
    private double fare;
    TaxiService(String name, double fare) { this.name = name; this.fare = fare; }
    public String getName() { return name; }
    public double getFare() { return fare; }
}

class AmbulanceService implements TransportService, EmergencyService {
    private String name;
    AmbulanceService(String name) { this.name = name; }
    public String getName() { return name; }
    public double getFare() { return 0; }
}

public class Smartcity {
    public static void main(String[] args) {
        List<TransportService> services = Arrays.asList(
            new BusService("City Bus", 15),
            new TaxiService("Taxi", 50),
            new AmbulanceService("Ambulance")
        );

        System.out.println("All Services:");
        services.forEach(TransportService::printDetails);

        System.out.println("\nCheap Services (< 40):");
        services.stream()
                .filter(s -> s.getFare() < 40)
                .sorted(Comparator.comparing(TransportService::getFare))
                .forEach(TransportService::printDetails);

        FareCalculator calc = (dist, rate) -> dist * rate;
        double fare = calc.calculate(10, 5);
        System.out.println("\nCalculated Fare (10km @ 5/unit): " + fare);

        System.out.println("\nEmergency Services:");
        services.stream()
                .filter(s -> s instanceof EmergencyService)
                .forEach(s -> System.out.println(s.getName() + " has priority!"));

        double totalFare = services.stream().collect(Collectors.summingDouble(TransportService::getFare));
        System.out.println("\nTotal fare collected: " + totalFare);
    }
}