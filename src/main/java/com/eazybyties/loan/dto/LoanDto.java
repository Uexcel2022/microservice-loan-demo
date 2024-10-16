package com.eazybyties.loan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoanDto {
    private String loanNumber;
    private String loanType;
    private String mobileNumber;
    private double totalLoan;
    private double amountPaid;
    private double outstandingAmount;
}
