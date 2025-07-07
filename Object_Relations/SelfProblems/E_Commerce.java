package com.bridgelaz;

import java.util.*;

// Product class
class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Product: " + name);
    }
}

// Order class: aggregates products
class Order {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void showOrder() {
        System.out.println("Order contains:");
        for (Product p : products) {
            p.show();
        }
    }
}

// Customer class
class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(Order o) {
        orders.add(o);
        System.out.println(name + " placed an order.");
    }
}

// Demo class
public class EcommerceDemo {
    public static void main(String[] args) {
        Customer c1 = new Customer("Ritika");

        Product p1 = new Product("Phone");
        Product p2 = new Product("Laptop");

        Order order = new Order();
        order.addProduct(p1);
        order.addProduct(p2);

        c1.placeOrder(order);

        order.showOrder();
    }
}
