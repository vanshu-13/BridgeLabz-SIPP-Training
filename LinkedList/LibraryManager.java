import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book prev, next;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;

    public void addAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(Book newBook) {
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(Book newBook, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newBook);
            return;
        }

        Book temp = head;
        int count = 1;

        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            addAtEnd(newBook);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
        }
    }

    public void removeByBookID(int bookID) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;

        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book ID not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book with ID " + bookID + " removed.");
    }

    public void searchByTitleOrAuthor(String keyword) {
        boolean found = false;
        Book temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    public void updateAvailability(int bookID, boolean availability) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = availability;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book ID not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\nBooks in Forward Order:");
        Book temp = head;

        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\nBooks in Reverse Order:");
        Book temp = tail;

        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total number of books: " + count);
    }

    private void displayBook(Book b) {
        System.out.println("ID: " + b.bookID + ", Title: " + b.title + ", Author: " + b.author +
                ", Genre: " + b.genre + ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
}


public class LibraryManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Management Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Specific Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title or Author");
            System.out.println("6. Update Availability");
            System.out.println("7. Display Books Forward");
            System.out.println("8. Display Books Reverse");
            System.out.println("9. Count Total Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: case 2: case 3: {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    boolean available = sc.nextBoolean();

                    Book book = new Book(title, author, genre, id, available);
                    if (choice == 1) library.addAtBeginning(book);
                    else if (choice == 2) library.addAtEnd(book);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        library.addAtPosition(book, pos);
                    }
                    break;
                }
                case 4:
                    System.out.print("Enter Book ID to Remove: ");
                    int idToRemove = sc.nextInt();
                    library.removeByBookID(idToRemove);
                    break;
                case 5:
                    System.out.print("Enter Title or Author to Search: ");
                    String keyword = sc.nextLine();
                    library.searchByTitleOrAuthor(keyword);
                    break;
                case 6:
                    System.out.print("Enter Book ID: ");
                    int idToUpdate = sc.nextInt();
                    System.out.print("Is Available (true/false): ");
                    boolean avail = sc.nextBoolean();
                    library.updateAvailability(idToUpdate, avail);
                    break;
                case 7:
                    library.displayForward();
                    break;
                case 8:
                    library.displayReverse();
                    break;
                case 9:
                    library.countBooks();
                    break;
                case 0:
                    System.out.println("Exiting Library Manager...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
