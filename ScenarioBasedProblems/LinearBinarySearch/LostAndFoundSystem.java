package LinearBinarySearch;

import java.util.*;

public class LostAndFoundSystem {
    private HashMap<String, LinkedList<String>> itemsMap;
    private HashSet<String> itemsSet;

    public LostAndFoundSystem() {
        itemsMap = new HashMap<>();
        itemsSet = new HashSet<>();
    }

    public boolean addItem(String type, String description) {
        if (itemsSet.contains(description)) {
            System.out.println("Duplicate item. Not adding: " + description);
            return false;
        }

        itemsSet.add(description);

        itemsMap.putIfAbsent(type, new LinkedList<>());
        itemsMap.get(type).add(description);
        return true;
    }

    public void inquire(String keyword) {
        boolean foundAny = false;
        System.out.println("Search results for keyword: " + keyword);
        for (Map.Entry<String, LinkedList<String>> entry : itemsMap.entrySet()) {
            String type = entry.getKey();
            LinkedList<String> itemList = entry.getValue();

            int position = 0;
            for (String item : itemList) {
                position++;
                if (item.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println("Type: " + type + ", Item: " + item + ", Position: " + position);
                    foundAny = true;
                }
            }
        }
        if (!foundAny) {
            System.out.println("No items found matching the keyword.");
        }
    }

    public void displayAllItems() {
        System.out.println("All Found Items:");
        for (Map.Entry<String, LinkedList<String>> entry : itemsMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            int index = 1;
            for (String item : entry.getValue()) {
                System.out.println("  " + index + ". " + item);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        LostAndFoundSystem system = new LostAndFoundSystem();

        system.addItem("Bags", "Black backpack with red straps");
        system.addItem("Mobile", "iPhone 12 blue color");
        system.addItem("Books", "Data Structures textbook");
        system.addItem("Bags", "Grey duffle bag");
        system.addItem("Mobile", "Samsung Galaxy S21");
        system.addItem("Bags", "Brown leather briefcase");

        system.addItem("Bags", "Black backpack with red straps");

        system.inquire("blue");
        system.inquire("Samsung");
        system.inquire("leather");
        system.inquire("green");
    }
}