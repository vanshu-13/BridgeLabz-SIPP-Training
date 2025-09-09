package LambdaExpression;

// Lambda Expression Example 2: Custom Sorting in E-Commerce

import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    int discount;

    Product(String name, double price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " (Price: " + price + ", Rating: " + rating + ", Discount: " + discount + "%)";
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {
        System.out.println("=== Custom Sorting in E-Commerce ===");

        List<Product> products = Arrays.asList(
                new Product("Laptop", 800, 4.5, 10),
                new Product("Phone", 500, 4.8, 20),
                new Product("Tablet", 300, 4.3, 15)
        );

        // Sort by price
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price: " + products);

        // Sort by rating
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("Sorted by Rating: " + products);

        // Sort by discount
        products.sort((p1, p2) -> Integer.compare(p2.discount, p1.discount));
        System.out.println("Sorted by Discount: " + products);
    }
}

