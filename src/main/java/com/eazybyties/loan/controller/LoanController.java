package com.eazybyties.loan.controller;

import com.eazybyties.loan.constants.LoanConstants;
import com.eazybyties.loan.dto.CreateLoanDto;
import com.eazybyties.loan.dto.ErrorResponseDto;
import com.eazybyties.loan.dto.LoanDto;
import com.eazybyties.loan.dto.ResponseDto;
import com.eazybyties.loan.service.ILoan;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "EazyBank Loan Microservice CRUD Operation APIs",
        description = "use to CREATE,FETCH,UPDATE AND DELETE loan details"
)


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LoanController {
    private final ILoan iloan;
    @Operation(
            summary = "REST API to Create Loan Details",
            description = "REST API use to create loan details in EazyBank",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Loan details created successfully",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseDto.class)
                            )

                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )
                    )

            }
    )

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoanDetails(
            @RequestBody CreateLoanDto createLoanDto){
        iloan.validateMobileOrLoanNumber(createLoanDto.getMobileNumber());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iloan.createLoanDetails(createLoanDto.getMobileNumber()));
    }
    @Operation(
            summary = "REST API to Fetch Loan Details",
            description = "REST API use to fetch loan details in EazyBank",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = LoanDto.class
                                    )
                            )

                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )

                    ),

                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )

                    )
            }
    )


    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> getLoanDetails(@RequestParam String mobileOrLoanNumber){
        iloan.validateMobileOrLoanNumber(mobileOrLoanNumber);
       return ResponseEntity.ok().body(iloan.fetchLoanDetails(mobileOrLoanNumber));
    }

    @Operation(
            summary = "REST API to Update Loan Details",
            description = "REST API use to create loan details in EazyBank",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Loan details updated successfully",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ResponseDto.class
                                    )
                            )

                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Exception Fail",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ResponseDto.class
                                    )
                            )

                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )

                    ),

                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )

                    )
            }
    )

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoanDto loanDto){
        boolean success = iloan.updateLoanDetails(loanDto);
        if(success){
            return ResponseEntity.ok()
                    .body(new ResponseDto(
                            LoanConstants.STATUS_CODE_200,LoanConstants.MESSAGE_200_UPDATE));
        }else {
            return ResponseEntity.ok()
                    .body(new ResponseDto(
                            LoanConstants.STATUS_CODE_417,LoanConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "REST API to Delete Loan Details",
            description = "REST API use to create loan details in EazyBank",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Loan details deleted successfully",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ResponseDto.class
                                    )
                            )

                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Exception Fail",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ResponseDto.class
                                    )
                            )

                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )

                    ),

                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorResponseDto.class
                                    )
                            )

                    )
            }

    )

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam String mobileOrLoanNumber){
        iloan.validateMobileOrLoanNumber(mobileOrLoanNumber);
        boolean success = iloan.deleteLoanDetails(mobileOrLoanNumber);
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
