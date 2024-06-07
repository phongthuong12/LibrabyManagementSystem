/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Phong
 */
public class Book implements Serializable{
    private String bookId;
    private String bookTitle;
    private String author;
    private int publicationYear;
    private String publisher;
    private boolean activeBook;

    public Book(String bookId, String bookTitle, String author, int publicationYear, String publisher, boolean activeBook) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.activeBook = activeBook;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isActiveBook() {
        return activeBook;
    }

    public void setActiveBook(boolean activeBook) {
        this.activeBook = activeBook;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + bookTitle + ", author=" + author +
               ", publicationYear=" + publicationYear + ", publisher=" + publisher + 
               ", activeBook=" + activeBook + "]";
    }
    
}
