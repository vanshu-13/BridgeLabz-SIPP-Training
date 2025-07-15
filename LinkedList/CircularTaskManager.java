import java.util.Scanner;

class Task {
    int id;
    String name;
    String priority;
    String dueDate;
    Task next;

    public Task(int id, String name, String priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add task at beginning
    public void addAtBeginning(Task newTask) {
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
            current = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add task at end
    public void addAtEnd(Task newTask) {
        if (head == null) {
            addAtBeginning(newTask);
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
    }

    // Add task at a specific position (1-based index)
    public void addAtPosition(Task newTask, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newTask);
            return;
        }

        Task temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove task by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head, prev = tail;

        do {
            if (temp.id == id) {
                if (temp == head) {
                    if (head == tail) { // Only one task
                        head = tail = null;
                        current = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                    }
                }

                if (current == temp) {
                    current = temp.next != temp ? temp.next : null;
                }

                System.out.println("Task with ID " + id + " removed.");
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Task not found.");
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);
    }

    // Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            System.out.println("Moved to next task.");
            viewCurrentTask();
        } else {
            System.out.println("No tasks to move to.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        System.out.println("\nAll Tasks:");
        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search tasks by priority
    public void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    private void displayTask(Task task) {
        System.out.println("ID: " + task.id + ", Name: " + task.name +
                ", Priority: " + task.priority + ", Due: " + task.dueDate);
    }
}

public class CircularTaskManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;

        do {
            System.out.println("\n=== Task Scheduler Menu ===");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: case 2: case 3: {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String dueDate = sc.nextLine();
                    Task t = new Task(id, name, priority, dueDate);

                    if (choice == 1) scheduler.addAtBeginning(t);
                    else if (choice == 2) scheduler.addAtEnd(t);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        scheduler.addAtPosition(t, pos);
                    }
                    break;
                }
                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    int idToRemove = sc.nextInt();
                    scheduler.removeById(idToRemove);
                    break;
                case 5:
                    scheduler.viewCurrentTask();
                    break;
                case 6:
                    scheduler.moveToNextTask();
                    break;
                case 7:
                    scheduler.displayAllTasks();
                    break;
                case 8:
                    System.out.print("Enter Priority to Search: ");
                    String prioritySearch = sc.nextLine();
                    scheduler.searchByPriority(prioritySearch);
                    break;
                case 0:
                    System.out.println("Exiting Task Scheduler...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
