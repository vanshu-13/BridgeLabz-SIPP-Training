package com.bridgelaz;

import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Book: " + title + " | Author: " + author);
    }
}

// Library class: Aggregates books using an ArrayList
class Library {
    private String name;
    private List<Book> books; // Aggregation - Library HAS-A list of Books

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Adds book to the library collection
    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Library: " + name + " contains:");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}

// Demonstration class
public class LibraryDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Java Basics", "James Gosling");
        Book book2 = new Book("Effective Java", "Joshua Bloch");

        // Book objects exist independently
        Library library1 = new Library("Central Library");
        Library library2 = new Library("Community Library");

        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2); // Same book in different library

        library1.showBooks();
        library2.showBooks();
    }
}
