package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    public String toString() { return name; }
}

class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
}

class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();

    void addItem(T item) { items.add(item); }

    void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    static void displayAnyStorage(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class Warehouse_ManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));
        
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apple"));
        groceriesStorage.addItem(new Groceries("Banana"));
        
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics Storage:");
        electronicsStorage.displayItems();
        
        System.out.println("\nGroceries Storage:");
        groceriesStorage.displayItems();
        
        System.out.println("\nFurniture Storage:");
        furnitureStorage.displayItems();

        System.out.println("\nDisplaying all items in a generic way:");
        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.addAll(electronicsStorage.items);
        allItems.addAll(groceriesStorage.items);
        allItems.addAll(furnitureStorage.items);
        
        Storage.displayAnyStorage(allItems);
    }
}