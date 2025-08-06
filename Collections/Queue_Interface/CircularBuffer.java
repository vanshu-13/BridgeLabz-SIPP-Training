package GENERICS.Collections.Queue_Interface;

import java.util.*;

public class CircularBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> buffer = new LinkedList<>();

        System.out.print("Enter buffer size: ");
        int size = sc.nextInt();

        while (true) {
            System.out.print("Insert value (-1 to stop): ");
            int val = sc.nextInt();
            if (val == -1) break;

            if (buffer.size() == size) buffer.poll(); // remove oldest
            buffer.add(val);
        }

        System.out.println("Buffer contents: " + buffer);
    }
}
