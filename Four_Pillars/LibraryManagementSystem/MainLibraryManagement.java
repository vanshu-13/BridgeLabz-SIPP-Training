import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainLibraryManagement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<LibraryItem> items = new ArrayList<>();

        System.out.println("Enter number of library items:");
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter item type (1-Book, 2-Magazine, 3-DVD):");
            int type = s.nextInt();
            s.nextLine();

            System.out.println("Enter item ID:");
            int itemId = s.nextInt();
            s.nextLine();

            System.out.println("Enter title:");
            String title = s.nextLine();

            System.out.println("Enter author:");
            String author = s.nextLine();

            LibraryItem item = null;
            switch (type) {
                case 1:
                    item = new Book(itemId, title, author);
                    break;
                case 2:
                    item = new Magazine(itemId, title, author);
                    break;
                case 3:
                    item = new DVD(itemId, title, author);
                    break;
                default:
                    System.out.println("Invalid item type.");
                    i--;
                    continue;
            }
            items.add(item);
        }

        System.out.println("\nLibrary Items Details:");
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Available for reservation: " + reservable.checkAvailability());
            }
            System.out.println("-----------------------");
        }

        // Do not close Scanner s as per instructions
    }
}
