package com.eazybyties.loan.service.impl;

import com.eazybyties.loan.constants.LoanConstants;
import com.eazybyties.loan.dto.LoanDto;
import com.eazybyties.loan.dto.ResponseDto;
import com.eazybyties.loan.entity.Loan;
import com.eazybyties.loan.exception.MobileNumberExistException;
import com.eazybyties.loan.exception.ResourceNotFoundException;
import com.eazybyties.loan.mapper.LoanMapper;
import com.eazybyties.loan.repository.LoanRepository;
import com.eazybyties.loan.service.ILoan;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
@Transactional
public class LoanServiceImpl implements ILoan {
    private final LoanRepository loanRepository;
    /**
     * @param loanDto - A request body to hold new loan information
     * @return  - Returns response code and message with ResponseDto objection
     */
    @Override
    public ResponseDto createLoanDetails(LoanDto loanDto) {
        if(loanRepository.existsByMobileNumber(loanDto.getMobileNumber())) {
            throw new MobileNumberExistException(loanDto.getMobileNumber());
        }
        loanRepository.save(LoanMapper.mapToNewLoan(loanDto,new Loan()));
        return new ResponseDto(LoanConstants.STATUS_CODE_201,LoanConstants.MESSAGE_201);
    }

    /**
     * @param mobileNumber - A request parameter to hold mobile number
     * @return Returns loan information with LoanDto object
     */
    @Override
    public LoanDto fetchLoanDetails(String mobileNumber) {
        return LoanMapper.mapToLoanDto(loanExists(mobileNumber),new LoanDto());
    }

    /**
     * @param loanDto - A request body to hold information to be updated
     * @return Returns boolean value indicating update is successful or not
     */
    @Override
    public boolean updateLoanDetails(LoanDto loanDto) {
        Loan loan = loanExists(loanDto.getMobileNumber());
         loanRepository.save(LoanMapper.mapToLoanUpdate(loanDto,loan));
        return true;
    }

    /**
     * @param mobileNumber - A request parameter hold mobile number
     * @return - Return boolean value indicating update is successful or not
     */
    @Override
    public boolean deleteLoanDetails(String mobileNumber) {
        loanRepository.delete(loanExists(mobileNumber));
        return true;
    }


    private Loan loanExists(String mobileNumber) {

        return  loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Loan","mobileNumber",mobileNumber));
    }
}
