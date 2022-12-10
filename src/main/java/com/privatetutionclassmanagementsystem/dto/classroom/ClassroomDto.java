package com.privatetutionclassmanagementsystem.dto.classroom;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClassroomDto {
    @NotBlank(message = "classroomCode is mandatory")
    private String classroomCode;
    @NotBlank(message = "classroomName is mandatory")
    private String classroomName;
    @NotNull(message = "createdBy is mandatory")
    private Integer createdBy;
    @NotBlank(message = "floor is mandatory")
    private String floor;
    @NotNull(message = "capacity is mandatory")
    private Integer capacity;
    @NotNull(message = "isAC is mandatory")
    private Boolean isAC;
    @NotNull(message = "isAvailable is mandatory")
    private Boolean isAvailable;
}
