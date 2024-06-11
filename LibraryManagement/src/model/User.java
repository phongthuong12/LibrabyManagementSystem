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
public class User implements Serializable {

    private String studentId;
    private String studentFullName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private boolean activeUser;

    public User(String studentId, String studentFullName, Date dateOfBirth, String phoneNumber, String email, boolean activeUser) {
        this.studentId = studentId;
        this.studentFullName = studentFullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.activeUser = activeUser;
    }

    public String getStudenId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNUmber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActiveUser() {
        return activeUser;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }

    @Override
    public String toString() {
        return "User [studentId=" + studentId + ", name=" + studentFullName + ", dateOfBirth=" + dateOfBirth
                + ", phoneNumber=" + phoneNumber + ", email=" + email + ", activeUser=" + activeUser + "]";
    }
}
