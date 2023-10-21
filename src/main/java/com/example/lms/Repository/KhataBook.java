package com.example.lms.Repository;


import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Loan;
import com.example.lms.Entities.Lumpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class KhataBook implements IKhataBook{


    private final ILoanAccountManager recordManager;

    private final IPaymentManager lumpsumManager;


    @Autowired
    public KhataBook(ILoanAccountManager recordManager, IPaymentManager lumpsumManager) {
        this.recordManager = recordManager;
        this.lumpsumManager = lumpsumManager;
    }

    @Override
    public void saveBorrower(Borrower borrower, Loan loan) {
        recordManager.saveBorrower(borrower,loan);
    }

    @Override
    public Loan getLoan(Bank bank, Borrower borrower) {
        return recordManager.getLoan(bank, borrower);
    }

    @Override
    public void updateLumpSum(Borrower borrower, Bank bank, Lumpsum lumpsum) {
        lumpsumManager.updateLumpSum(borrower,bank,lumpsum);
    }
}
