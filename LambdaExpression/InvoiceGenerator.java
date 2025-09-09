package LambdaExpression;

// Method Reference Example 3: Invoice Object Creation

import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;

    // Constructor
    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice{TransactionID='" + transactionId + "'}";
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        System.out.println("=== Invoice Object Creation ===");

        List<String> transactionIds = Arrays.asList("TXN001", "TXN002", "TXN003");

        // Using constructor reference Invoice::new
        List<Invoice> invoices = transactionIds.stream()
                                               .map(Invoice::new)
                                               .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
