package com.example.lms.Repository;


import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Loan;
import com.example.lms.Entities.Lumpsum;

public interface IKhataBook extends IPaymentManager,ILoanAccountManager {


    @Override
    void saveBorrower(Borrower borrower, Loan loan);

    @Override
    Loan getLoan(Bank bank, Borrower borrower);

    @Override
    void updateLumpSum(Borrower borrower, Bank bank, Lumpsum lumpsum);


}
