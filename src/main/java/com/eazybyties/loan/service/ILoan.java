package com.eazybyties.loan.service;

import com.eazybyties.loan.dto.LoanDto;
import com.eazybyties.loan.dto.ResponseDto;
import com.eazybyties.loan.exception.InvalidArgumentException;

public interface ILoan {
    /**
     * @param mobileNumber - A mobil number to create new loan details
     * @return  - Returns response code and message with ResponseDto objection
     */
    ResponseDto createLoanDetails(String mobileNumber);

    /**
     * @param mobileOrLoanNumber - A request parameter to hold mobile or loan number
     * @return Returns loan information with LoanDto object
     */
    LoanDto fetchLoanDetails(String mobileOrLoanNumber);

    /**
     * @param loanDto - A request body to hold information to be updated
     * @return Returns boolean value indicating update is successful or not
     */
    boolean updateLoanDetails(LoanDto loanDto);

    /**
     * @param mobileOrLoanNumber - A request parameter hold mobile or loan number
     * @return - Return boolean value indicating update is successful or not
     */
    boolean deleteLoanDetails(String mobileOrLoanNumber);


    /**
     * @param mobileNumber - mobile number
     */
    default void validateMobileNumber(String mobileNumber) {
        boolean isValid = mobileNumber.matches(("^0[7-9][01][0-9]{8}$"));
        if(!isValid){
            throw new InvalidArgumentException(
                    String.format("Mobile number %s is invalid", mobileNumber));
        }

    }



}
