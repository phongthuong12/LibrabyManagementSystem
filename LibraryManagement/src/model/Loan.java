/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Phong
 */
public class Loan implements Serializable {

    private String transactionId;
    private Book book;
    private User user;
    private Date borrowDate;
    private Date returnDate;

    public Loan(String transactionId, Book book, User user, Date borrowDate, Date returnDate) {
        this.transactionId = transactionId;
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan [transactionId=" + transactionId + ", book=" + book
                + ", user=" + user + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + "]";
    }
}
