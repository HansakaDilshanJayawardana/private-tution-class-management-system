package com.privatetutionclassmanagementsystem.dto.subject;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SubjectDto {
    @NotBlank(message = "subjectCode is mandatory")
    private String subjectCode;
    @NotBlank(message = "description is mandatory")
    private String description;
    @NotNull(message = "createdBy is mandatory")
    private Integer createdBy;
    @NotNull(message = "isAvailable is mandatory")
    private Boolean isAvailable;
    @NotNull(message = "icon is mandatory")
    private String icon;
}
