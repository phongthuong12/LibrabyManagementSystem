/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
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
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");
        System.out.println("| Book ID    | Title                 | Author                | Year       | Publisher         | ISBN          |");
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");
        System.out.printf("| %-10s | %-21s | %-21s | %-10d | %-17s | %-13s |\n",
                book.getBookId(), book.getBookTitle(), book.getAuthor(), book.getPublicationYear(), book.getPublisher(), book.getISBN());
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");

        System.out.println("Book information updated successfully!");
    }

    public void deleteABook() {
        String bookId = validation.getString("Enter a Book ID to delete: ");
        Book book = bookCollection.getById(bookId);

        if (book == null || !book.isActiveBook()) {
            System.out.println("Error: Book ID does not exist or is already deleted!!");
            return;
        }

        String bookTitle = book.getBookTitle();
        System.out.println("Are you sure you want to delete: " + bookTitle + "? (y/n): ");

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            book.setActiveBook(false);
            System.out.println("The book has been successfully deleted!");
        } else {
            System.out.println("Deletion cancelled!!");
            return;
        }

        displayAllActiveBooks();
    }

    public void displayAllActiveBooks() {
        Map<String, Book> booksMap = bookCollection.getAll();
        List<Book> activeBooks = booksMap.values().stream()
                .filter(Book::isActiveBook)
                .collect(Collectors.toList());

        int numberOfActiveBooks = activeBooks.size();

        System.out.println("Number of active books: " + numberOfActiveBooks);
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");
        System.out.println("| Book ID    | Title                 | Author                | Year       | Publisher         | ISBN          |");
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");

        for (Book book : activeBooks) {
            System.out.printf("| %-10s | %-21s | %-21s | %-10d | %-17s | %-13s |\n",
                    book.getBookId(), book.getBookTitle(), book.getAuthor(), book.getPublicationYear(), book.getPublisher(), book.getISBN());
        }
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");
    }

    public void showAllBooks() {
        Map<String, Book> bookMap = bookCollection.getAll();
        List<Book> allBooks = new ArrayList<>(bookMap.values());

        System.out.println("All Books:");
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");
        System.out.println("| Book ID    | Title                 | Author                | Year       | Publisher         | ISBN          |");
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");

        for (Book book : allBooks) {
            System.out.printf("| %-10s | %-21s | %-21s | %-10d | %-17s | %-13s |\n",
                    book.getBookId(), book.getBookTitle(), book.getAuthor(), book.getPublicationYear(), book.getPublisher(), book.getISBN());
        }
        System.out.println("+------------+-----------------------+-----------------------+------------+-------------------+---------------+");
    }

    public void addAUser() {
        while (true) {
            String studentId;
            while (true) {
                studentId = validation.getString("Enter Student ID: ");
                if (userCollection.getById(studentId) != null) {
                    System.out.println("Error: Student ID already exist. Please Enter a unique Student ID!!");
                } else {
                    break;
                }
            }

            String studentFullName = validation.getString("Enter Full Name: ");
            Date dateOfBirth = validation.inputDate();
            String phoneNumber = validation.getString("Enter Phone Number: ");
            String email = validation.getEmail();

            User newUser = new User(studentId, studentFullName, dateOfBirth, phoneNumber, email, true);
            userCollection.add(newUser);
            System.out.println("New User Added Successfully!");

            System.out.println("Do you want to continue adding a new user? (y/n): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public void updateAUser() {
        while (true) {
            String userId = validation.getString("Enter User ID to update: ");
            User userToUpdate = userCollection.getById(userId);

            if (userToUpdate == null) {
                System.out.println("Error: User ID does not exist!!");
                return;
            }

            System.out.println("Updating information for User ID: " + userId);

            String studentFullName = validation.getStringOrEmpty("Enter new Full Name (leave empty to keep current): ");
            if (!studentFullName.isEmpty()) {
                userToUpdate.setStudentFullName(studentFullName);
            }

            Date dateOfBirth = validation.inputDate();
            userToUpdate.setDateOfBirth(dateOfBirth);

            String phoneNumber = validation.getStringOrEmpty("Enter new Phone Number (leave empty to keep current): ");
            if (!phoneNumber.isEmpty()) {
                userToUpdate.setPhoneNumber(phoneNumber);
            }

            String email = validation.getEmail();
            userToUpdate.setEmail(email);

            System.out.println("User information updated successfully!");

            System.out.println("User information updated successfully!");
            System.out.println("+------------+-----------------+---------------+----------------+-----------------------+-------------+");
            System.out.println("| User ID    | Full Name       | Date of Birth | Phone Number   | Email                 | Active User |");
            System.out.println("+------------+-----------------+---------------+----------------+-----------------------+-------------+");
            System.out.printf("| %-10s | %-15s | %-13s | %-14s | %-21s | %-11s |\n",
                    userToUpdate.getStudentId(), userToUpdate.getStudentFullName(), userToUpdate.getDateOfBirth(),
                    userToUpdate.getPhoneNumber(), userToUpdate.getEmail(), userToUpdate.isActiveUser());
            System.out.println("+------------+-----------------+---------------+----------------+-----------------------+-------------+");

            System.out.println("Do you want to continue updating another user? (y/n): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public void deleteAUser() {
        while (true) {
            String studentId = validation.getString("Enter Student ID to Delete: ");
            User userToDelete = userCollection.getById(studentId);

            if (userToDelete == null) {
                System.out.println("Error: User with ID " + studentId + " is not exist!!");
                return;
            }

            System.out.println("Are you sure you want to delete the user with the Student ID: " + studentId);
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("y")) {
                userToDelete.setActiveUser(false);
                System.out.println("User with Student ID: " + studentId + " has been deleted successfully!");
            } else {
                System.out.println("Deletion Cancelled!!");
                return;
            }

//            displayAllActiveUsers();
        }
    }

//    public void displayAllActiveUsers() {
//    List<User> allUsers = userCollection.getAll();
//    List<User> activeUsers = new ArrayList<>();
//
//    for (User user : allUsers) {
//        if (user.isActiveUser()) {
//            activeUsers.add(user);
//        }
//    }
//
//    int numberOfActiveUsers = activeUsers.size();
//
//    System.out.println("Number of active users: " + numberOfActiveUsers);
//    System.out.println("+--------------+----------------------+------------+----------------+---------------+");
//    System.out.println("| Student ID   | Full Name            | Date       | Phone Number   | Email         |");
//    System.out.println("+--------------+----------------------+------------+----------------+---------------+");
//
//    for (User user : activeUsers) {
//        System.out.printf("| %-12s | %-20s | %-10s | %-14s | %-13s |\n",
//                user.getStudentId(), user.getStudentFullName(), user.getDateOfBirth(), user.getPhoneNumber(), user.getEmail());
//    }
//    System.out.println("+--------------+----------------------+------------+----------------+---------------+");
//}
}
