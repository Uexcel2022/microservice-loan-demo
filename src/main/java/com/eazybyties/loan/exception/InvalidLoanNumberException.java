package com.eazybyties.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidLoanNumberException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public InvalidLoanNumberException() {
        super("Invalid loan number,must be 12 digits");
    }
}
