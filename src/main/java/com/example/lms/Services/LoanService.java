package com.example.lms.Services;


import com.example.lms.Dto.AddLoanData;
import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Emi;
import com.example.lms.Entities.Loan;
import com.example.lms.Repository.IKhataBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoanService implements ILoanService {


    private final IKhataBook records;

    private final int NO_OF_MONTHS_PER_YEAR = 12;
    private final int ROI_TO_NORMAL = 100;


    @Autowired
    public LoanService(IKhataBook records) {
        this.records = records;
    }

    public void saveEntry(AddLoanData loanData){
        Bank bank = new Bank(loanData.getBankName());
        Borrower borrower = new Borrower(loanData.getBorrowerName());
        Double principal = Double.valueOf(loanData.getPrincipal());
        Double years = Double.valueOf(loanData.getYears());
        Double ROI = Double.valueOf(loanData.getRoi());
        Double amountToPay = calculateTotalAmountToPay(principal, years, ROI);

        Emi emi = calculateFinalEMI(amountToPay, years);
        Loan loan = new Loan(bank,borrower,emi,amountToPay);
        records.saveBorrower(borrower,loan);
    }
    Double calculateTotalAmountToPay(Double principal, Double years, Double ROI){
        Double rateOfInterest = ROI/ROI_TO_NORMAL;
        Double interest = (principal * years * rateOfInterest);
        Double finalAmount = principal + interest;
        return finalAmount;
    }

    Emi calculateFinalEMI(Double finalAmountToPay, Double years) {

        Integer totalEmi = (int) Math.ceil(years*NO_OF_MONTHS_PER_YEAR);
        Integer costPerEmi = (int) Math.ceil(finalAmountToPay/totalEmi);
        Emi emi = new Emi(totalEmi,costPerEmi);

        return emi;

    }
}
