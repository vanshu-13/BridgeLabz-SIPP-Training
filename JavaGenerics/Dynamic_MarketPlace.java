package com.bridgelabz;

interface Category { }

class BookCategory implements Category { }
class ClothingCategory implements Category { }
class GadgetCategory implements Category { }

class Product<T extends Category> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " - $" + price;
    }
}

class ProductUtils {
    public static <T extends Category> void applyDiscount(Product<T> product, double percent) {
        product.price -= product.price * percent / 100;
    }
}

public class Dynamic_MarketPlace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 29.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 19.99, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, new GadgetCategory());

        System.out.println("Before Discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        ProductUtils.applyDiscount(book, 10);
        ProductUtils.applyDiscount(shirt, 15);
        ProductUtils.applyDiscount(phone, 5);

        System.out.println("\nAfter Discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}