package com.example.lms.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
public class BalanceRequest {

    @NotNull
    @JsonProperty("bankName")
    private String bankName;
    @NotNull
    @JsonProperty("borrowerName")
    private String borrowerName;

    @NotNull
    @JsonProperty("emiNo")
    private String emiNo;

    public BalanceRequest() {
    }

    public BalanceRequest(String bankName, String borrowerName, String emiNo) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.emiNo = emiNo;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getEmiNo() {
        return emiNo;
    }
}
