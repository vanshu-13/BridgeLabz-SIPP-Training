import java.util.Scanner;

class student{
    String name;
    int age;
    String grade;
    int rollno;
    student next;

    public student(int rollno, String name, int age, String grade){
        this.name= name;
        this.age=age;
        this.grade=grade;
        this.rollno= rollno;
        this.next=null;
    }
}

class StudentLinkedList{
    private student head=null;
    public void addFirst(student newStudent){
        newStudent.next=head;
        head=newStudent;
    }

    public void addLast(student newStudent){
        if(head==null){
            head=newStudent;
            return;
        }
        student temp=head;
        while (temp.next!=null) {
            temp = temp.next;
        }
        temp.next=newStudent;
    }

    public void addPosition(student newStudent, int pos){
        if(pos<=1 || head==null){
            head=newStudent;
            return;
        }
        student temp=head;
        int count=1;
        while(temp!=null || count<pos-1){
            temp= temp.next;
            count++;
        }
        if(temp==null){
            System.out.println("Out of range, Adding at end");
            addLast(newStudent);
        } else {
            newStudent.next= temp.next;
            temp.next=newStudent;
        }
    }

    public void deleteByRollno(int rollno){
        if(head==null){
            System.out.println("Empty List");
            return;
        }
        if(head.rollno==rollno){
            head=head.next;
            return;
        }
        student temp=head;
        while(temp.next!=null && temp.next.rollno!=rollno){
            temp= temp.next;
        }
        if(temp.next==null){
            System.out.println("Not found");
        }
        else {
            temp.next= temp.next.next;
        }
    }

    public void searchByRollno(int rollno){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        student temp=head;
        while (temp!=null){
            if(temp.rollno==rollno){
                System.out.println("Name:"+temp.name+", Roll no:"+temp.rollno+", Age:"+temp.age+", Grade:"+temp.grade);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Not Found");
    }
    public void upgradeGrade(int rollno, String newGrade){
        if(head==null){
            System.out.println("Empty List");
            return;
        }
        student temp=head;
        while (temp != null) {
            if (temp.rollno== rollno) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not found");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }

        student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollno + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;
        do {
            System.out.println("\n---- Student Record Management ----");
            System.out.println("1. Add Student (Beginning)");
            System.out.println("2. Add Student (End)");
            System.out.println("3. Add Student (Specific Position)");
            System.out.println("4. Delete Student by Roll No");
            System.out.println("5. Search Student by Roll No");
            System.out.println("6. Update Grade by Roll No");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: case 2: case 3: {
                    System.out.print("Enter Roll No: ");
                    int rollno = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    student s = new student(rollno, name, age, grade);
                    if (choice == 1) list.addFirst(s);
                    else if (choice == 2) list.addLast(s);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addPosition(s, pos);
                    }
                    break;
                }
                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    int rollToDelete = sc.nextInt();
                    list.deleteByRollno(rollToDelete);
                    break;
                case 5:
                    System.out.print("Enter Roll No to Search: ");
                    int rollToSearch = sc.nextInt();
                    list.searchByRollno(rollToSearch);
                    break;
                case 6:
                    System.out.print("Enter Roll No to Update Grade: ");
                    int rollToUpdate = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter New Grade: ");
                    String newGrade = sc.nextLine();
                    list.upgradeGrade(rollToUpdate, newGrade);
                    break;
                case 7:
                    list.displayAll();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 0);
    }
}
