package dailyTaskPlanner;

import java.util.LinkedList;
import java.util.ListIterator;

public class DailyTaskPlanner {
    public static void main(String[] args) {
        LinkedList<Task> tasks = new LinkedList<>();

        tasks.add(new Meeting("Team sync at 10 AM"));
        tasks.add(new Workout("Morning run at 6 AM"));
        tasks.add(new CodingSession("Implement feature X"));

        System.out.println("Executing all tasks:");
        for (Task task : tasks) {
            task.execute();
        }

        System.out.println("\nSearching for tasks with keyword 'run':");
        searchByKeyword(tasks, "run");

        System.out.println("\nSearching for tasks with keyword 'team':");
        searchByKeyword(tasks, "team");
    }

    public static void searchByKeyword(LinkedList<Task> tasks, String keyword) {
        boolean found = false;
        ListIterator<Task> iterator = tasks.listIterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + task.getDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with keyword: " + keyword);
        }
    }
}