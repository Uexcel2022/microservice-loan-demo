package com.eazybyties.loan.service;

import com.eazybyties.loan.dto.LoanDto;
import com.eazybyties.loan.dto.ResponseDto;

public interface ILoan {
    /**
     * @param loanDto - A request body to hold new loan information
     * @return  - Returns response code and message with ResponseDto objection
     */
    ResponseDto createLoanDetails(LoanDto loanDto);

    /**
     * @param mobileNumber - A request parameter to hold mobile number
     * @return Returns loan information with LoanDto object
     */
    LoanDto fetchLoanDetails(String mobileNumber);

    /**
     * @param loanDto - A request body to hold information to be updated
     * @return Returns boolean value indicating update is successful or not
     */
    boolean updateLoanDetails(LoanDto loanDto);

    /**
     * @param mobileNumber - A request parameter hold mobile number
     * @return - Return boolean value indicating update is successful or not
     */
    boolean deleteLoanDetails(String mobileNumber);
}
