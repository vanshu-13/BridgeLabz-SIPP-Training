package GENERICS.Collections.Queue_Interface;

import java.util.*;

public class StackUsingQueues {
    static class MyStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.isEmpty() ? -1 : q1.remove();
        }

        public int top() {
            return q1.isEmpty() ? -1 : q1.peek();
        }

        public boolean isEmpty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack();

        System.out.print("Enter number of elements to push: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top after pop: " + stack.top());
    }
}
