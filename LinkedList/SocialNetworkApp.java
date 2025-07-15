import java.util.*;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialNetwork {
    private User head = null;

    public void addUser(int userID, String name, int age) {
        if (getUserById(userID) != null) {
            System.out.println("User ID already exists.");
            return;
        }

        User newUser = new User(userID, name, age);
        newUser.next = head;
        head = newUser;
        System.out.println("User added successfully.");
    }

    public void searchUser(String key) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.userID).equals(key) || temp.name.equalsIgnoreCase(key)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("User not found.");
        }
    }

    public void addFriendConnection(int id1, int id2) {
        User user1 = getUserById(id1);
        User user2 = getUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIDs.contains(id2)) user1.friendIDs.add(id2);
        if (!user2.friendIDs.contains(id1)) user2.friendIDs.add(id1);
        System.out.println("Friend connection added.");
    }

    public void removeFriendConnection(int id1, int id2) {
        User user1 = getUserById(id1);
        User user2 = getUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIDs.remove(Integer.valueOf(id2));
        user2.friendIDs.remove(Integer.valueOf(id1));
        System.out.println("Friend connection removed.");
    }

    public void displayFriends(int userID) {
        User user = getUserById(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (user.friendIDs.isEmpty()) {
            System.out.println(user.name + " has no friends.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int fid : user.friendIDs) {
            User friend = getUserById(fid);
            if (friend != null)
                System.out.println(" - " + friend.name + " (ID: " + friend.userID + ")");
        }
    }

    public void findMutualFriends(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User(s) not found.");
            return;
        }

        Set<Integer> mutual = new HashSet<>(u1.friendIDs);
        mutual.retainAll(u2.friendIDs);

        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println("Mutual friends:");
            for (int fid : mutual) {
                User friend = getUserById(fid);
                if (friend != null)
                    System.out.println(" - " + friend.name + " (ID: " + friend.userID + ")");
            }
        }
    }
    public void countAllFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friends.");
            temp = temp.next;
        }
    }

    private User getUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    private void displayUser(User u) {
        System.out.println("User ID: " + u.userID + ", Name: " + u.name + ", Age: " + u.age);
    }
}


public class SocialNetworkApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork network = new SocialNetwork();
        int choice;

        do {
            System.out.println("\n--- Social Media Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Search User");
            System.out.println("3. Add Friend Connection");
            System.out.println("4. Remove Friend Connection");
            System.out.println("5. Display Friends of User");
            System.out.println("6. Find Mutual Friends");
            System.out.println("7. Count Friends of All Users");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    network.addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("Enter Name or User ID to Search: ");
                    String key = sc.nextLine();
                    network.searchUser(key);
                    break;

                case 3:
                    System.out.print("Enter User ID 1: ");
                    int id1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int id2 = sc.nextInt();
                    network.addFriendConnection(id1, id2);
                    break;

                case 4:
                    System.out.print("Enter User ID 1: ");
                    int r1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int r2 = sc.nextInt();
                    network.removeFriendConnection(r1, r2);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    network.displayFriends(uid);
                    break;

                case 6:
                    System.out.print("Enter User ID 1: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int m2 = sc.nextInt();
                    network.findMutualFriends(m1, m2);
                    break;

                case 7:
                    network.countAllFriends();
                    break;

                case 0:
                    System.out.println("Exiting Social Media System...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
