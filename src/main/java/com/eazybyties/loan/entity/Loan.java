package com.eazybyties.loan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Loan {
    @Id
    private Long loanId;
    private String loanNumber;
    private String loanType;
    private String mobileNumber;
    private double totalLoan;
    private double amountPaid;
    private double outstandingAmount;
}

//`loan_id` int NOT NULL AUTO_INCREMENT,
//  `mobile_number` varchar(15) NOT NULL,
//  `loan_number` varchar(100) NOT NULL,
//  `loan_type` varchar(100) NOT NULL,
//  `total_loan` int NOT NULL,
//        `amount_paid` int NOT NULL,
//        `outstanding_amount` int NOT NULL,
//        `created_at` date NOT NULL,
//        `created_by` varchar(20) NOT NULL,
//  `updated_at` date DEFAULT NULL,
//        `updated_by` varchar(20) DEFAULT NULL,
//PRIMARY KEY (`loan_id`)
