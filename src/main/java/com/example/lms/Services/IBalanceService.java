package com.example.lms.Services;


import com.example.lms.Dto.BalanceDto;
import com.example.lms.Dto.BalanceRequest;

public interface IBalanceService {
    BalanceDto getBalance(BalanceRequest balanceRequest);
}
