package org.example.model;

import java.util.UUID;

public class Book {

    private String title;
    private String author;
    private boolean available;

    private final String id;

    private Person borrower;


    // Default constructor for creating a new book instance.
    // Generates a unique ID for the book and sets it as available.
    private Book() {
        this.id = UUID.randomUUID().toString();
        this.available = true;
    }


    // Creates a book instance with the given title and author.
    // Initializes the book with a unique ID and sets it as available.
    // Here is the constructor including the default constructor.
    public Book(String title, String author) {
        this();
        setTitle(title);
        setAuthor(author);
    }


    // Creates a book instance with the given title, author and borrower.
    // Here is a clear example of how chaining constructors are used, using "this()" argument in the first line-
    // to include the desired constructor and so add the desired input/output.
    public Book(String title, String author, Person borrower) {
        this(title, author);
        setBorrower(borrower);
    }


    // Gets the unique ID of the book.
    public String getId() {
        return id;
    }


    // Gets the title of the book.
    public String getTitle() {
        return title;
    }


    // Sets the title of the book.
    public void setTitle(String title) {
        this.title = title;
    }


    // Gets the author of the book.
    public String getAuthor() {
        return author;
    }


    // Sets the author of the book.
    public void setAuthor(String author) {
        if (author == null) throw new IllegalArgumentException("Author cannot be null");
        this.author = author;
    }


    // Checks if the book is available for borrowing.
    public boolean isAvailable() {
        return available;
    }


    // Gets the person who has borrowed the book.
    public Person getBorrower() {
        return borrower;
    }


    // Sets the borrower for the book and updates availability accordingly.
    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.available = (borrower == null);
    }


    // Retrieves information about the person that has borrowed the book.
    public String showPerson() {
        return borrower.getPersonInformation();
    }

    /*
    public Person showPerson() {
        return borrower;
    }
     */


    // Generates a string representation about the book´s information.
    // *Java Ternary Operator
    // *https://careerkarma.com/blog/java-ternary-operator/
    // *variable = (expression) ? expressionIsTrue : expressionIsFalse;
    public  String getBookInformation() {
        return "Book{ id=" + id + ", title=" + title + ", author=" + author + ", available=" +
                ", borrower=" + (borrower != null ? " PersonId: " + borrower.getPersonId() : "-") + "}";
    }
}
