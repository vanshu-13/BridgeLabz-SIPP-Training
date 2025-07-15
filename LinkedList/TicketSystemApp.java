import java.util.*;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private int ticketCount = 0;

    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }

        ticketCount++;
        System.out.println("Ticket booked successfully.");
    }

    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = tail;
        boolean found = false;

        do {
            if (current.ticketID == ticketID) {
                found = true;
                if (current == head && current == tail) { // only one node
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = prev;
                }
                ticketCount--;
                System.out.println("Ticket ID " + ticketID + " cancelled.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) System.out.println("Ticket ID not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("\n--- Booked Tickets ---");
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID +
                    ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        boolean found = false;
        Ticket temp = head;

        do {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                    temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketID +
                        ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber +
                        ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No matching tickets found.");
    }

    public void countTickets() {
        System.out.println("Total Booked Tickets: " + ticketCount);
    }
}

public class TicketSystemApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        int choice;

        do {
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer/Movie");
            System.out.println("5. Count Total Tickets");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Customer Name: ");
                    String customer = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, customer, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int removeId = sc.nextInt();
                    system.removeTicket(removeId);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer or Movie Name to search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;

                case 5:
                    system.countTickets();
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}

