package com.privatetutionclassmanagementsystem.dto.subject;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SubjectUpdateDto {
    private String subjectCode;
    private String description;
    @NotNull(message = "modifiedBy is mandatory")
    private Integer modifiedBy;
    private Boolean isAvailable;
    private String icon;
}
