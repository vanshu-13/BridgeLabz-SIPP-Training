import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState current;
    private int size;
    private final int MAX_HISTORY = 10;

    public TextEditor() {
        head = current = new TextState("");
        size = 1;
    }

    public void type(String newText) {
        current.next = null;

        TextState newState = new TextState(newText);
        newState.prev = current;
        current.next = newState;
        current = newState;

        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public void showCurrentState() {
        System.out.println("Current Text: \"" + current.content + "\"");
    }

    public void printHistory() {
        TextState temp = head;
        System.out.println("\n--- History ---");
        while (temp != null) {
            System.out.println((temp == current ? "-> " : "   ") + "\"" + temp.content + "\"");
            temp = temp.next;
        }
        System.out.println("----------------\n");
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type/Edit Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. View History");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text content: ");
                    String newText = sc.nextLine();
                    editor.type(newText);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.showCurrentState();
                    break;
                case 5:
                    editor.printHistory();
                    break;
                case 0:
                    System.out.println("Exiting editor.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
