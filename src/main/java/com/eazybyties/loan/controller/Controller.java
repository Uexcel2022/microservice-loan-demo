package com.eazybyties.loan.controller;

import com.eazybyties.loan.constants.LoanConstants;
import com.eazybyties.loan.dto.LoanDto;
import com.eazybyties.loan.dto.ResponseDto;
import com.eazybyties.loan.service.ILoan;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class Controller {
    private final ILoan iloan;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoanDetails(LoanDto loanDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iloan.createLoanDetails(loanDto));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> getLoanDetails(@RequestParam String mobileNumber){
       return ResponseEntity.ok().body(iloan.fetchLoanDetails(mobileNumber));
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(LoanDto loanDto){
        boolean success = iloan.updateLoanDetails(loanDto);
        if(success){
            return ResponseEntity.ok()
                    .body(new ResponseDto(
                            LoanConstants.MESSAGE_200_UPDATE,LoanConstants.MESSAGE_200_UPDATE));
        }else {
            return ResponseEntity.ok()
                    .body(new ResponseDto(
                            LoanConstants.STATUS_CODE_417,LoanConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam String mobileNumber){
        boolean success = iloan.deleteLoanDetails(mobileNumber);
        if(success){
            return ResponseEntity.ok()
                    .body(new ResponseDto(
                            LoanConstants.STATUS_CODE_200,LoanConstants.MESSAGE_200_DELETE));
        }else {
            return ResponseEntity.ok()
                    .body(new ResponseDto(
                            LoanConstants.STATUS_CODE_417,LoanConstants.MESSAGE_417_DELETE));
        }
    }


}
