package com.example.lms.Services;


import com.example.lms.Dto.BalanceDto;
import com.example.lms.Dto.BalanceRequest;
import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Loan;
import com.example.lms.Entities.Lumpsum;
import com.example.lms.Repository.IKhataBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BalanceService implements IBalanceService{
    private final IKhataBook records;

    @Autowired
    public BalanceService(IKhataBook record) {
        this.records = record;
    }
    public BalanceDto getBalance(BalanceRequest balanceRequest) {

        Bank bank = new Bank(balanceRequest.getBankName());
        Borrower borrower = new Borrower(balanceRequest.getBorrowerName());
        int emiCount = Integer.parseInt(balanceRequest.getEmiNo());
        Loan loan = records.getLoan(bank, borrower);


        int emiCost = loan.getEmiCost();
        int amountPaid = calculateAmountPaid(emiCount, loan, emiCost);
        int emiRemains = calculateEmiRemains(loan, amountPaid, emiCost);

        BalanceDto statement = new BalanceDto(
                bank.getBankName(),
                borrower.getuserName(),
                amountPaid,
                emiRemains
        );

        return statement;
    }

    private int calculateAmountPaid(int emiCount, Loan loan, int emiCost) {
        if (!loan.isLumpsumBeforeEmi(emiCount)) {
            return emiCount * emiCost;
        } else {

            int sum = loan.getLumpSumBeforeEmi(emiCount).stream()
                    .mapToInt(Lumpsum::getAmount).sum();
            int amountPaid = emiCount * emiCost + sum;
            return (amountPaid > loan.getTotalAmountToPay())?loan.getTotalAmountToPay().intValue():amountPaid;
        }
    }

    private int calculateEmiRemains(Loan loan, int amountPaid, int emiCost) {
        int remainingAmount = (int)Math.max(0, loan.getTotalAmountToPay() - amountPaid);
        return (int) Math.ceil(remainingAmount / (double) emiCost);
    }



}
