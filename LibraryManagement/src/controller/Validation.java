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
    
    public Validation(){
        this.scanner = new Scanner(System.in);
    }
    
    public int getInt(){
        int number;
        while(true){
            System.out.println("Enter a integer: ");
            try{
                number = Integer.parseInt(scanner.nextLine());
                return number;
            }catch(NumberFormatException e){
                System.out.println("Error: Invalid number format. Please enter a valid integer!!");
            }
        }
    }
    
    public String getString(){
        String input;
        while(true){
            System.out.println("Enter a String: ");
            input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }else{
                System.out.println("Error: Input cannot be empty. Please enter a valid String!!");
            }
        }
    }
    
    public Date inputDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date currentDate = new Date();
        Date inputDate;
        
        while(true){
            System.out.println("Enter a Date (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            try{
                inputDate= sdf.parse(dateStr);
                if (inputDate.after(currentDate)) {
                    return inputDate;
                }else{
                    System.out.println("Error: Date must be in the future. Please try again!!");
                }
            } catch(ParseException e){
                System.out.println("Error: Invalid date format (dd/MM/yyyy). Please try again!!");
            }
        }
    }
}
