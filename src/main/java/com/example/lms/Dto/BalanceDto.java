package com.example.lms.Dto;

import lombok.Data;

@Data
public class BalanceDto {
    private String bankname;
    private String borrowerName;
    private Integer amountpaid;
    private Integer emiRemains;

    public BalanceDto() {
    }

    public BalanceDto(String bankName, String borrowerName, Integer amountPaid, Integer emiRemains) {
        this.bankname = bankName;
        this.borrowerName = borrowerName;
        this.amountpaid = amountPaid;
        this.emiRemains = emiRemains;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Integer getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(Integer amountpaid) {
        this.amountpaid = amountpaid;
    }

    public Integer getEmiRemains() {
        return emiRemains;
    }

    public void setEmiRemains(Integer emiRemains) {
        this.emiRemains = emiRemains;
    }


}
