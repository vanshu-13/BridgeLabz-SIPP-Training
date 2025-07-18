package LinearBinarySearch;

import java.util.*;

public class SmartRestaurantMenu {

    static class Dish {
        String name;
        String type;
        List<String> tags;

        public Dish(String name, String type, List<String> tags) {
            this.name = name.toLowerCase(); // for case-insensitive search
            this.type = type;
            this.tags = new ArrayList<>();
            for (String tag : tags) {
                this.tags.add(tag.toLowerCase());
            }
        }

        public void displayDetails() {
            System.out.println("Dish Name: " + name);
            System.out.println("Type: " + type);
            System.out.println("Tags: " + tags);
            System.out.println("-------------------------");
        }
    }

    public static List<Dish> searchDishes(List<Dish> menu, String keyword, boolean preventDuplicates) {
        List<Dish> matchedDishes = new ArrayList<>();
        Set<String> seenNames = new HashSet<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Dish dish : menu) {
            if (dish.name.contains(lowerKeyword) || dish.tags.stream().anyMatch(tag -> tag.contains(lowerKeyword))) {
                if (preventDuplicates) {
                    if (!seenNames.contains(dish.name)) {
                        matchedDishes.add(dish);
                        seenNames.add(dish.name);
                    }
                } else {
                    matchedDishes.add(dish);
                }
            }
        }
        return matchedDishes;
    }

    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Paneer Tikka", "Starter", Arrays.asList("vegetarian", "spicy", "grilled")));
        menu.add(new Dish("Spicy Chicken Curry", "Main", Arrays.asList("spicy", "chicken", "hot")));
        menu.add(new Dish("Garden Salad", "Starter", Arrays.asList("vegetarian", "healthy")));
        menu.add(new Dish("Paneer Butter Masala", "Main", Arrays.asList("vegetarian", "creamy", "spicy")));
        menu.add(new Dish("Fried Rice", "Main", Arrays.asList("vegetarian", "fried", "rice")));
        menu.add(new Dish("Paneer Tikka", "Starter", Arrays.asList("vegetarian", "spicy", "grilled"))); // duplicate name

        String keyword = "paneer";

        List<Dish> results = searchDishes(menu, keyword, true);

        System.out.println("Search results for keyword: " + keyword);
        for (Dish dish : results) {
            dish.displayDetails();
        }
    }
}