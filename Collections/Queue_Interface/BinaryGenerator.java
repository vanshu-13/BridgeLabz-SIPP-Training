package GENERICS.Collections.Queue_Interface;

import java.util.*;
public class BinaryGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Generate N binary numbers: ");
        int n = sc.nextInt();

        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String current = q.poll();
            System.out.print(current + " ");
            q.add(current + "0");
            q.add(current + "1");
        }
    }
}
