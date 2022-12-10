package com.privatetutionclassmanagementsystem.dto.classroom;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClassroomUpdateDto {
    private String classroomCode;
    private String classroomName;
    @NotNull(message = "modifiedBy is mandatory")
    private Integer modifiedBy;
    private String floor;
    private Integer capacity;
    private Boolean isAC;
    private Boolean isAvailable;
}
