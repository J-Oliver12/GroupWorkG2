package org.example.model;


import java.util.Arrays;

// Represents a person in the library system who can borrow book.
public class Person {

    private final Integer personId;
    private String firstName;
    private String lastName;

    private Book[] borrowedBooks;


    // Default constructor for creating a new person instance.
    // Generates a unique personId and initializes an empty array of borrowed book.
    private Person() {
        this.personId = PersonSequencer.getNextId();
        this.borrowedBooks = new Book[0];
    }


    // Creates a person instance with the given first name and last name.
    // Initializes a unique person ID and an empty array of borrowed books.
    // Here is this constructor including the default constructor and adding the setters for first and last name.
    public Person(String firstName, String lastName) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
    }


    // Borrows a book and adds it to the list of borrowed books.
    // "isAvailable" and "setBorrower" is called from the "Book Class"
    public void loanBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");

        if (book.isAvailable()) {
            book.setBorrower(this);
            Book[] newArray = Arrays.copyOf(borrowedBooks, borrowedBooks.length +1);
            newArray[newArray.length -1] = book;
            borrowedBooks = newArray;
        } else {
            throw new IllegalArgumentException("Book is not available");
        }

    }


    // Returns borrowed books and removes it from the list of borrowed books.
    // "getId" and "setBorrower" is called from the "Book Class"
    public void returnBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");

        Book[] newArray = new Book[borrowedBooks.length - 1];
        int counter = 0;
        for (Book elementArray : borrowedBooks) {
            if (elementArray.getId().equals(book.getId())) {
                book.setBorrower(null);
                continue;
            }
            newArray[counter++] = elementArray;
        }
        borrowedBooks = newArray;
    }


    // Retrieves information about the person, including their ID, first name, last name and number of borrowed books.
    public String getPersonInformation() {
        return "Person{ personId=" + personId + ", firstName='" + firstName + ", lastName'" + lastName +
                ",number of borrowedBooks=" + borrowedBooks.length + '}';
    }


    // Generates a string containing the details of books borrowed by the person.
    // "getBookInformation" is called from the "Book Class"
    public String displayBooks() {
        StringBuilder stringBuilder = new StringBuilder();
        if (borrowedBooks != null) {
            for (Book book : borrowedBooks) {
                stringBuilder.append(book.getBookInformation()).append("\n");
            }
        }
        return  stringBuilder.toString();
    }


    // Gets the unique ID of the person.
    public Integer getPersonId() {
        return personId;
    }


    // Gets the first name of the person.
    public String getFirstName() {
        return firstName;
    }


    // Sets the first name of the person.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    // Gets the last name of the person.
    public String getLastName() {
        return lastName;
    }


    // Sets the last name of the person.
    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("LastName cannot be null");
        this.lastName = lastName;
    }


    // Gets the array of borrowed books by the person.
    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }
}
