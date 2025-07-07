import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainECommercePlatform {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.println("Enter number of products:");
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter product type (1-Electronics, 2-Clothing, 3-Groceries):");
            int type = s.nextInt();
            s.nextLine();

            System.out.println("Enter product ID:");
            int productId = s.nextInt();
            s.nextLine();

            System.out.println("Enter product name:");
            String name = s.nextLine();

            System.out.println("Enter price:");
            double price = s.nextDouble();
            s.nextLine();

            Product product = null;
            switch (type) {
                case 1:
                    System.out.println("Enter tax rate (e.g., 0.18 for 18%):");
                    double taxRateE = s.nextDouble();
                    s.nextLine();
                    product = new Electronics(productId, name, price, taxRateE);
                    break;
                case 2:
                    System.out.println("Enter tax rate (e.g., 0.12 for 12%):");
                    double taxRateC = s.nextDouble();
                    s.nextLine();
                    product = new Clothing(productId, name, price, taxRateC);
                    break;
                case 3:
                    product = new Groceries(productId, name, price);
                    break;
                default:
                    System.out.println("Invalid product type.");
                    i--;
                    continue;
            }
            products.add(product);
        }

        System.out.println("\nProduct Details and Final Price:");
        for (Product p : products) {
            System.out.println("Product ID: " + p.getProductId());
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            double discount = p.calculateDiscount();
            double tax = 0;
            String taxDetails = "No tax applicable";
            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                taxDetails = t.getTaxDetails();
            }
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println(taxDetails);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-----------------------");
        }

        // Do not close Scanner s as per instructions
    }
}
