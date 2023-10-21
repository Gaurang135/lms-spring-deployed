package com.example.lms.controller;


import com.example.lms.Dto.AddLoanData;
import com.example.lms.Dto.AddLumpsumRequest;
import com.example.lms.Dto.BalanceDto;
import com.example.lms.Dto.BalanceRequest;
import com.example.lms.Services.IService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/v2")
@SecurityRequirement(name = "lmsapi")
public class ApplicationController {



    private final IService serviceImpl;

    @Autowired
    public ApplicationController(IService serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @GetMapping()
    public String loggedIn(){
        return "Log in Successful !";
    }

    @GetMapping("/say")
    public String sayHello() {
        return "Hello Spring boot";
    }

    @GetMapping( "/BALANCE")
    public ResponseEntity<BalanceDto> getBalance(@RequestBody @Valid BalanceRequest balanceRequest) {

        BalanceDto balanceDto = serviceImpl.getBalance(balanceRequest);
        return ResponseEntity.ok().body(balanceDto);
    }


    @PostMapping("/LOAN")
    public ResponseEntity<Void> addLoan(@RequestBody @Valid AddLoanData loanData) {

        serviceImpl.saveEntry(loanData);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/PAYMENT")
    public ResponseEntity<Void> updateLumpsum(@RequestBody @Valid AddLumpsumRequest addLumpsumRequest) {
        serviceImpl.addPayment(addLumpsumRequest);
        return ResponseEntity.ok().build();
    }





}
