import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieList {
    Movie head = null;
    Movie tail = null;

    public void addAtBeginning(Movie newMovie) {
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(Movie newMovie) {
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(Movie newMovie, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newMovie);
            return;
        }

        Movie temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(newMovie);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }

    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie \"" + title + "\" removed.");
    }

    public void searchByDirector(String director) {
        boolean found = false;
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by that director.");
    }

    public void searchByRating(double rating) {
        boolean found = false;
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with that rating.");
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for \"" + title + "\".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("\nMovies (Forward):");
        Movie temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("\nMovies (Reverse):");
        Movie temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    private void displayMovie(Movie m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director +
                ", Year: " + m.year + ", Rating: " + m.rating);
    }
}

public class MovieManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList movieList = new MovieList();
        int choice;

        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies (Forward)");
            System.out.println("9. Display Movies (Reverse)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: case 2: case 3: {
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    Movie m = new Movie(title, director, year, rating);

                    if (choice == 1) movieList.addAtBeginning(m);
                    else if (choice == 2) movieList.addAtEnd(m);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        movieList.addAtPosition(m, pos);
                    }
                    break;
                }
                case 4:
                    System.out.print("Enter Title to Remove: ");
                    String removeTitle = sc.nextLine();
                    movieList.removeByTitle(removeTitle);
                    break;
                case 5:
                    System.out.print("Enter Director to Search: ");
                    String director = sc.nextLine();
                    movieList.searchByDirector(director);
                    break;
                case 6:
                    System.out.print("Enter Rating to Search: ");
                    double rating = sc.nextDouble();
                    movieList.searchByRating(rating);
                    break;
                case 7:
                    System.out.print("Enter Title to Update Rating: ");
                    String updateTitle = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    movieList.updateRating(updateTitle, newRating);
                    break;
                case 8:
                    movieList.displayForward();
                    break;
                case 9:
                    movieList.displayBackward();
                    break;
                case 0:
                    System.out.println("Exiting Movie Manager...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

    }
}
