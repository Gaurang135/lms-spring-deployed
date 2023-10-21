package com.example.lms.Services;


import com.example.lms.Dto.AddLoanData;
import com.example.lms.Dto.AddLumpsumRequest;
import com.example.lms.Dto.BalanceDto;
import com.example.lms.Dto.BalanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService{


    private final IBalanceService balanceService;

    private final ILoanService loanService;

    private final IPaymentService paymentService;

    @Autowired
    public ServiceImpl(IBalanceService balanceService, ILoanService loanService, IPaymentService paymentService) {
        this.balanceService = balanceService;
        this.loanService = loanService;
        this.paymentService = paymentService;
    }

    @Override
    public BalanceDto getBalance(BalanceRequest balanceRequest) {
        return balanceService.getBalance(balanceRequest);
    }

    @Override
    public void saveEntry(AddLoanData loanData) {

        loanService.saveEntry(loanData);
    }

    @Override
    public void addPayment(AddLumpsumRequest addLumpsumRequest) {
        paymentService.addPayment(addLumpsumRequest);
    }
}
