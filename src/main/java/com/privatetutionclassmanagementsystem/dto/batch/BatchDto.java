package com.privatetutionclassmanagementsystem.dto.batch;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BatchDto {
    @NotBlank(message = "batchCode is mandatory")
    private String batchCode;
    @NotBlank(message = "batchName is mandatory")
    private String batchName;
    @NotNull(message = "createdBy is mandatory")
    private Integer createdBy;
    @NotNull(message = "isCurrent is mandatory")
    private Boolean isCurrent;
}
