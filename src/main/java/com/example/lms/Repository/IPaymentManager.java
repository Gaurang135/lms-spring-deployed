package com.example.lms.Repository;


import com.example.lms.Entities.Bank;
import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Lumpsum;

public interface IPaymentManager {

    void updateLumpSum(Borrower borrower, Bank bank, Lumpsum lumpsum);

}
