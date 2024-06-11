/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.Book;
import model.Loan;
import model.User;

/**
 *
 * @author Phong
 */
public class LibraryManagement {

    private I_Collection<Book> bookCollection;
    private I_Collection<User> userCollection;
    private I_Collection<Loan> loanCollection;
    private Validation validation;
    private Scanner scanner;

    public LibraryManagement() {
        bookCollection = new BookCollection();
        userCollection = new UserCollection();
        loanCollection = new LoanCollection();
        validation = new Validation();
        scanner = new Scanner(System.in);
    }

    public void addABook() {
        while (true) {
            String bookId;
            while (true) {
                bookId = validation.getString("Enter Book ID: ");
                if (bookCollection.getById(bookId) != null) {
                    System.out.println("Error: Book ID already exists. Please enter a unique Book ID!!");
                } else {
                    break;
                }
            }

            String bookTitle = validation.getString("Enter Book Title: ");
            String author = validation.getString("Enter Author: ");
            int publicationYear = validation.getInt("Enter Publication Year: ");
            String publisher = validation.getString("Enter Publisher: ");
            String ISBN = validation.getISBN("Enter ISBN: ");

            Book newBook = new Book(bookId, bookTitle, author, publicationYear, publisher, ISBN, true);
            bookCollection.add(newBook);
            System.out.println("Book added successfully!");

            System.out.println("Do you want to continue adding books? (y/n): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public void updateABook() {
        String bookId = validation.getString("Enter Book ID to update: ");
        Book book = bookCollection.getById(bookId);

        if (book == null) {
            System.out.println("Error: Book ID does not exist!!");
            return;
        }

        System.out.println("Updating information for Book ID: " + bookId);

        String bookTitle = validation.getStringOrEmpty("Enter new Book Title (leave empty to keep current): ");
        if (!bookTitle.isEmpty()) {
            book.setBookTitle(bookTitle);
        }

        String author = validation.getStringOrEmpty("Enter new Author (leave empty to keep current): ");
        if (!author.isEmpty()) {
            book.setAuthor(author);
        }

        Integer publicationYear = validation.getIntOrEmpty("Enter new Publication Year (leave empty to keep current): ");
        if (publicationYear != null) {
            book.setPublicationYear(publicationYear);
        }

        String publisher = validation.getStringOrEmpty("Enter new Publisher (leave empty to keep current): ");
        if (!publisher.isEmpty()) {
            book.setPublisher(publisher);
        }

        String ISBN = validation.getISBN("Enter new ISBN (leave empty to keep current): ");
        if (!ISBN.isEmpty()) {
            book.setISBN(ISBN);
        }

        System.out.println("Book information updated successfully!");
    }

    public void deleteABook() {

    }
}
