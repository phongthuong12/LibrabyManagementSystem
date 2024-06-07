/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Loan;

/**
 *
 * @author Phong
 */
public class LoanCollection implements I_Collection<Loan>{
    private Map<String, Loan> loans;
    
    public LoanCollection(){
        loans = new HashMap<>();
    }

    @Override
    public void add(Loan loan) {
        loans.put(loan.getLoanId(), loan);
    }

    @Override
    public void update(Loan loan) {
        if (loans.containsKey(loan.getLoanId())) {
            loans.put(loan.getLoanId(), loan);
        }
    }

    @Override
    public void delete(String id) {
loans.remove(id);
    }

    @Override
    public Loan getById(String id) {
return loans.get(id);    
    }

    @Override
    public List<Loan> getAll() {
return new ArrayList<>(loans.values());    
    }
}
