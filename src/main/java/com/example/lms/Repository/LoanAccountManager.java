package com.example.lms.Repository;


import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Primary
public class LoanAccountManager implements ILoanAccountManager {

    public final HashMap<Borrower, List<Loan>> recordBook;


    @Autowired
    public LoanAccountManager(HashMap<Borrower, List<Loan>> recordBook) {
        this.recordBook = recordBook;
    }

    @Override
    public void saveBorrower(Borrower borrower, Loan loan) {
        recordBook.computeIfAbsent(borrower, k -> new ArrayList<>()).add(loan);


    }

    @Override
    public Loan getLoan(Bank bank, Borrower borrower) {

        Loan foundLoan = recordBook.get(borrower).stream()
                .filter(loan -> loan.getBank().getBankName().equals(bank.getBankName()))
                .findFirst().get();

        return foundLoan;
    }

}
