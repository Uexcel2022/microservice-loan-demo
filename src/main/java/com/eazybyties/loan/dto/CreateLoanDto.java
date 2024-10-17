package com.eazybyties.loan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Schema(
        name = "Request",
        description = "Schema to hold mobile number from the request body for creating loan"
)
@Getter @Setter @ToString
public class CreateLoanDto {
    @Schema(
            description = "Customer mobile number",
            example = "07138263824"
    )
    private String mobileNumber;
}
