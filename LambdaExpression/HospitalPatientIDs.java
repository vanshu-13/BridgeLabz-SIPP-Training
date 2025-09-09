package LambdaExpression;

// Method Reference Example 1: Hospital Patient ID Printing

import java.util.*;

public class HospitalPatientIDs {
    public static void main(String[] args) {
        System.out.println("=== Hospital Patient ID Printing ===");

        List<String> patientIds = Arrays.asList("P101", "P102", "P103", "P104");

        // Using method reference instead of lambda
        patientIds.forEach(System.out::println);
    }
}
