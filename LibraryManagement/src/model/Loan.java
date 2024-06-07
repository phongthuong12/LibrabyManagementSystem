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

    private String loanId;
    private String bookId;
    private String userId;
    private Date borrowDate;
    private Date returnDate;

    public Loan(String loanId, String bookId, String userId, Date borrowDate, Date returnDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoadId(String loanId) {
        this.loanId = loanId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "Loan [loanId=" + loanId + ", bookId=" + bookId
                + ", userId=" + userId + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + "]";
    }
}
