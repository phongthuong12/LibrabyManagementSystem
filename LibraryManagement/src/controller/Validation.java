/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Phong
 */
public class Validation {

    private Scanner scanner;

    public Validation() {
        this.scanner = new Scanner(System.in);
    }

    public int getInt(String prompt) {
        int number;
        while (true) {
            System.out.println("Enter a integer: ");
            try {
                number = Integer.parseInt(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please enter a valid integer!!");
            }
        }
    }

    public String getString(String prompt) {
        String input;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println("Error: Input cannot be empty. Please enter a valid string!!");
            }
        }
    }

    public String getStringOrEmpty(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public Integer getIntOrEmpty(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return null;
        }
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please enter a valid integer!!");
                input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    return null;
                }
            }
        }
    }

    public String getISBN(String prompt) {
        String isbn;
        while (true) {
            System.out.println(prompt);
            isbn = scanner.nextLine();
            if (isValidISBN10(isbn) || isValidISBN13(isbn)) {
                return isbn;
            } else {
                System.out.println("Error: Invalid ISBN format. Please enter a valid ISBN!!");
            }
        }
    }

    private boolean isValidISBN10(String isbn) {
        if (!isbn.matches("\\\\d{9}[\\\\dX]")) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (isbn.charAt(i) - '0') * (10 - i);
        }
        char checksum = isbn.charAt(9);
        sum += (checksum == 'X') ? 10 : (checksum - '0');
        return sum % 11 == 0;
    }

    private boolean isValidISBN13(String isbn) {
        if (!isbn.matches("\\d{13}")) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (isbn.charAt(i) - '0') * ((i % 2 == 0) ? 1 : 3);
        }
        sum += (isbn.charAt(12) - '0');
        return sum % 10 == 0;
    }

    public Date inputDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date currentDate = new Date();
        Date inputDate;

        while (true) {
            System.out.println("Enter a Date (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            try {
                inputDate = sdf.parse(dateStr);
                if (inputDate.after(currentDate)) {
                    return inputDate;
                } else {
                    System.out.println("Error: Date must be in the future. Please try again!!");
                }
            } catch (ParseException e) {
                System.out.println("Error: Invalid date format (dd/MM/yyyy). Please try again!!");
            }
        }
    }

}
