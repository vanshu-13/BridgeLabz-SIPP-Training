import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    public void addAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(Item newItem, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newItem);
            return;
        }

        Item temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newItem.next = (temp != null) ? temp.next : null;
        if (temp != null) temp.next = newItem;
        else addAtEnd(newItem);
    }

    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item ID not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    public void searchItem(String key) {
        boolean found = false;
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.id).equals(key) || temp.name.equalsIgnoreCase(key)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    public void totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void sortInventory(String by, boolean ascending) {
        head = mergeSort(head, by, ascending);
        System.out.println("Inventory sorted by " + by + " in " + (ascending ? "ascending" : "descending") + " order.");
    }

    private Item mergeSort(Item head, String by, boolean ascending) {
        if (head == null || head.next == null) return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, by, ascending);
        Item right = mergeSort(nextOfMiddle, by, ascending);

        return sortedMerge(left, right, by, ascending);
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Item sortedMerge(Item a, Item b, String by, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        int cmp;
        if (by.equalsIgnoreCase("name")) {
            cmp = a.name.compareToIgnoreCase(b.name);
        } else {
            cmp = Double.compare(a.price, b.price);
        }

        if ((asc && cmp <= 0) || (!asc && cmp > 0)) {
            a.next = sortedMerge(a.next, b, by, asc);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, by, asc);
            return b;
        }
    }

    private void displayItem(Item item) {
        System.out.println("ID: " + item.id + ", Name: " + item.name +
                ", Qty: " + item.quantity + ", Price: ₹" + item.price);
    }
}


public class InventoryManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Specific Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search Item by ID or Name");
            System.out.println("7. Display All Items");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: case 2: case 3: {
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    Item item = new Item(name, id, qty, price);

                    if (choice == 1) inventory.addAtBeginning(item);
                    else if (choice == 2) inventory.addAtEnd(item);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(item, pos);
                    }
                    break;
                }
                case 4:
                    System.out.print("Enter Item ID to Remove: ");
                    int id = sc.nextInt();
                    inventory.removeById(id);
                    break;
                case 5:
                    System.out.print("Enter Item ID to Update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    inventory.updateQuantity(updateId, newQty);
                    break;
                case 6:
                    System.out.print("Enter Item ID or Name to Search: ");
                    String key = sc.nextLine();
                    inventory.searchItem(key);
                    break;
                case 7:
                    inventory.displayAll();
                    break;
                case 8:
                    inventory.totalInventoryValue();
                    break;
                case 9:
                    System.out.print("Sort by (name/price): ");
                    String by = sc.nextLine();
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sortInventory(by, asc);
                    break;
                case 0:
                    System.out.println("Exiting Inventory System.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);

        sc.close();
    }
}
