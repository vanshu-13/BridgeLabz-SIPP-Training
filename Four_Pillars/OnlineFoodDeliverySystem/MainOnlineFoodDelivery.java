import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainOnlineFoodDelivery {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<FoodItem> order = new ArrayList<>();

        System.out.println("Enter number of food items:");
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter food item type (1-Veg, 2-NonVeg):");
            int type = s.nextInt();
            s.nextLine();

            System.out.println("Enter item name:");
            String name = s.nextLine();

            System.out.println("Enter price:");
            double price = s.nextDouble();
            s.nextLine();

            System.out.println("Enter quantity:");
            int quantity = s.nextInt();
            s.nextLine();

            FoodItem item = null;
            if (type == 1) {
                item = new VegItem(name, price, quantity);
            } else if (type == 2) {
                System.out.println("Enter additional charge for non-veg item:");
                double additionalCharge = s.nextDouble();
                s.nextLine();
                item = new NonVegItem(name, price, quantity, additionalCharge);
            } else {
                System.out.println("Invalid food item type.");
                i--;
                continue;
            }
            order.add(item);
        }

        System.out.println("\nOrder Details:");
        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable discountable = (Discountable) item;
                discountable.applyDiscount(10); // example discount 10%
                System.out.println(discountable.getDiscountDetails());
            }
            System.out.println("Total Price: " + item.calculateTotalPrice());
            System.out.println("-----------------------");
        }

        // Do not close Scanner s as per instructions
    }
}
