package com.example.lms.Services;


import com.example.lms.Dto.AddLumpsumRequest;
import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Lumpsum;
import com.example.lms.Repository.IKhataBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService implements IPaymentService {

    private final IKhataBook khataBook;

    @Autowired
    public PaymentService(IKhataBook khataBook) {
        this.khataBook = khataBook;
    }

    public void addPayment(AddLumpsumRequest addLumpsumRequest) {
        Borrower borrower = new Borrower(addLumpsumRequest.getBorrowerName());
        Bank bank = new Bank(addLumpsumRequest.getBankName());

        Lumpsum payment = new Lumpsum(Integer.parseInt(addLumpsumRequest.getAmount()), Integer.parseInt(addLumpsumRequest.getEmi()));
        khataBook.updateLumpSum(borrower,bank,payment);
    }

}
