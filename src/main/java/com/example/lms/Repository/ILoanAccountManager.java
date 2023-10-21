package com.example.lms.Repository;


import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Loan;

public interface ILoanAccountManager {
    void saveBorrower(Borrower borrower, Loan loan);

    Loan getLoan(Bank bank, Borrower borrower);
}
