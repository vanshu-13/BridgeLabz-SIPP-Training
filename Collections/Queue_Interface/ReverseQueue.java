package GENERICS.Collections.Queue_Interface;

import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter number of elements in queue: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) stack.push(queue.remove());
        while (!stack.isEmpty()) queue.add(stack.pop());

        System.out.println("Reversed Queue: " + queue);
    }
}
