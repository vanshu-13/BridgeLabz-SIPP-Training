package browserHistoryNavigation;

public class BrowserHistory {
    private HistoryNode current;

    public BrowserHistory(String homepage) {
        current = new HistoryNode(homepage);
    }

    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        System.out.println("Visited: " + url);
    }

    public String back(int steps) {
        while (current.prev != null && steps-- > 0) {
            current = current.prev;
        }
        System.out.println("Moved back to: " + current.url);
        return current.url;
    }

    public String forward(int steps) {
        while (current.next != null && steps-- > 0) {
            current = current.next;
        }
        System.out.println("Moved forward to: " + current.url);
        return current.url;
    }

    public String getCurrentPage() {
        return current.url;
    }
}