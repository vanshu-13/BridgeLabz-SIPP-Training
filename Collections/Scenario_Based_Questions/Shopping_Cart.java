package GENERICS.Collections.Scenario_Based_Questions;

import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> priceSortedItems = new TreeMap<>();

    // Add product with price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        priceSortedItems.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }

    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found.");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Display cart in insertion order
    public void displayCart() {
        System.out.println("Cart (in insertion order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            System.out.println(product + " - Qty: " + quantity + ", Price: ₹" + price);
        }
    }

    // Display products sorted by price
    public void displayProductsSortedByPrice() {
        System.out.println("Products sorted by price:");
        for (Map.Entry<Double, List<String>> entry : priceSortedItems.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                System.out.println(product + " - ₹" + price);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 30.0);
        cart.addProduct("Banana", 10.0);
        cart.addProduct("Mango", 50.0);
        cart.addProduct("Orange", 25.0);

        cart.addToCart("Banana", 5);
        cart.addToCart("Apple", 2);
        cart.addToCart("Mango", 1);

        cart.displayCart();
        System.out.println();
        cart.displayProductsSortedByPrice();
    }
}

