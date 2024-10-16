package com.eazybyties.loan.mapper;

import com.eazybyties.loan.dto.LoanDto;
import com.eazybyties.loan.entity.Loan;

public class LoanMapper {

    public static Loan mapToLoan(LoanDto loanDto, Loan loan) {
        loan.setLoanType(loanDto.getLoanType());
        loan.setTotalLoan(loanDto.getTotalLoan());
        loan.setMobileNumber(loanDto.getMobileNumber());
        return loan;
    }

    public static LoanDto mapToLoanDto(Loan loan, LoanDto loanDto) {
        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setTotalLoan(loan.getTotalLoan());
        loanDto.setMobileNumber(loan.getMobileNumber());
        return loanDto;
    }
}
