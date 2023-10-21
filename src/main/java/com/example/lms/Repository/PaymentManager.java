package com.example.lms.Repository;


import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Loan;
import com.example.lms.Entities.Lumpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;


@Repository
@Primary
public class PaymentManager implements IPaymentManager{

    private final HashMap<Borrower, List<Loan>> recordBook;

    private final ILoanAccountManager loanAccountManager;

    @Autowired
    public PaymentManager(HashMap<Borrower, List<Loan>> recordBook, ILoanAccountManager loanAccountManager) {
        this.recordBook = recordBook;
        this.loanAccountManager = loanAccountManager;
    }

    @Override
    public void updateLumpSum(Borrower borrower, Bank bank, Lumpsum lumpsum) {

        Loan loan = loanAccountManager.getLoan(bank, borrower);

        loan.addLumpsum(lumpsum);

    }
}
