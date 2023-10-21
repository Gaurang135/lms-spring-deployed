package com.example.lms.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class AddLoanData {

    @NotNull
    @JsonProperty("bankName")
    private String bankName;

    @NotNull
    @JsonProperty("borrowerName")
    private String borrowerName;

    @NotNull
    @JsonProperty("principal")
    private String principal;

    @NotNull
    @JsonProperty("years")
    private String years;

    @NotNull
    @JsonProperty("roi")
    private String roi;

    public AddLoanData() {
    }

    public AddLoanData(String bankName, String borrowerName, String principal, String years, String roi) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.years = years;
        this.roi = roi;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getYears() {
        return years;
    }

    public String getRoi() {
        return roi;
    }
}
