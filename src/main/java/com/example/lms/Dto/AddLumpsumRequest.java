package com.example.lms.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class AddLumpsumRequest {

    @JsonProperty("bankName")
    @NotNull
    private String bankName;

    @NotNull
    @JsonProperty("borrowerName")
    private String borrowerName;

    @NotNull
    @JsonProperty("amount")
    private String amount;

    @NotNull
    @JsonProperty("emi")
    private String emi;

    public AddLumpsumRequest() {
    }

    public AddLumpsumRequest(String bankName, String borrowerName, String amount, String emi) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.amount = amount;
        this.emi = emi;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmi() {
        return emi;
    }

    public void setEmi(String emi) {
        this.emi = emi;
    }
}
