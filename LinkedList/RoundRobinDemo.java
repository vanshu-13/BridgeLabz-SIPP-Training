import java.util.*;

class Process {
    int id;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int processCount = 0;

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);

        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }

        processCount++;
    }

    public void removeProcess(int id) {
        if (head == null) return;

        Process current = head, prev = tail;

        do {
            if (current.id == id) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = prev;
                }
                processCount--;
                return;
            }

            prev = current;
            current = current.next;
        } while (current != head);
    }
    public void displayQueue() {
        if (head == null) {
            System.out.println("No processes.");
            return;
        }

        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("[P" + temp.id + ": RT=" + temp.remainingTime + "] → ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        System.out.println("\n--- Starting Round Robin Simulation ---");
        Process current = head;
        int time = 0;

        while (processCount > 0) {
            if (current.remainingTime > 0) {
                int timeUsed = Math.min(current.remainingTime, timeQuantum);
                System.out.println("Time " + time + ": Executing P" + current.id + " for " + timeUsed + " units.");
                current.remainingTime -= timeUsed;
                time += timeUsed;

                Process temp = current.next;
                while (temp != current) {
                    if (temp.remainingTime > 0) {
                        temp.waitingTime += timeUsed;
                    }
                    temp = temp.next;
                }

                if (current.remainingTime == 0) {
                    current.turnaroundTime = time;
                    System.out.println("P" + current.id + " completed. Turnaround: " +
                            current.turnaroundTime + ", Waiting: " + current.waitingTime);
                    removeProcess(current.id);
                }
            }

            current = current.next;
            displayQueue();
        }

        System.out.println("--- Simulation Complete ---");
        displayAverageTimes();
    }

    public void displayAverageTimes() {
        double totalWT = 0, totalTAT = 0;
        int completed = 0;
        Process temp = head;

        if (temp == null) return;

        do {
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            completed++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Average Waiting Time: " + (totalWT / completed));
        System.out.println("Average Turnaround Time: " + (totalTAT / completed));
    }
}


public class RoundRobinDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Burst Time for Process " + i + ": ");
            int bt = sc.nextInt();
            System.out.print("Enter Priority for Process " + i + ": ");
            int pr = sc.nextInt();
            scheduler.addProcess(i, bt, pr);
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        scheduler.displayQueue();
        scheduler.simulateRoundRobin(tq);

        sc.close();
    }
}

