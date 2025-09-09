package LambdaExpression;

// Lambda Expression Example 3: Notification Filtering in Hospital App

import java.util.*;
import java.util.function.Predicate;

public class NotificationFiltering {
    public static void main(String[] args) {
        System.out.println("=== Notification Filtering in Hospital App ===");

        List<String> alerts = Arrays.asList(
                "Critical: Heart rate abnormal",
                "Info: Appointment reminder",
                "Warning: High blood pressure",
                "Info: Diet suggestion"
        );

        // Predicate: show only critical alerts
        Predicate<String> isCritical = alert -> alert.startsWith("Critical");
        System.out.println("Critical Alerts:");
        alerts.stream().filter(isCritical).forEach(System.out::println);

        // Predicate: show only info alerts
        Predicate<String> isInfo = alert -> alert.startsWith("Info");
        System.out.println("\nInfo Alerts:");
        alerts.stream().filter(isInfo).forEach(System.out::println);
    }
}

