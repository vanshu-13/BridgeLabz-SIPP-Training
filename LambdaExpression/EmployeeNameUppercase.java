package LambdaExpression;

// Method Reference Example 2: Name Uppercasing

import java.util.*;

public class EmployeeNameUppercase {
    public static void main(String[] args) {
        System.out.println("=== Employee Names in Uppercase ===");

        List<String> employees = Arrays.asList("Akanksha", "Ravi", "Meena", "Vikram");

        // Using String::toUpperCase
        employees.stream()
                 .map(String::toUpperCase)
                 .forEach(System.out::println);
    }
}
