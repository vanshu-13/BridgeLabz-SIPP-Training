package GENERICS.Collections.List_Interface;

import java.util.*;

public class FindNthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> lead = list.iterator();
        Iterator<T> follow = list.iterator();

        for (int i = 0; i < n; i++) {
            if (lead.hasNext()) lead.next();
            else return null;
        }

        while (lead.hasNext()) {
            lead.next();
            follow.next();
        }

        return follow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        String nth = findNthFromEnd(names, 2);
        System.out.println("2nd from End: " + nth);
    }
}
