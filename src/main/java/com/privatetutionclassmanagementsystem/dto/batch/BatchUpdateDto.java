package com.privatetutionclassmanagementsystem.dto.batch;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BatchUpdateDto {
    private String batchCode;
    private String batchName;
    @NotNull(message = "modifiedBy is mandatory")
    private Integer modifiedBy;
    private Boolean isCurrent;
}
