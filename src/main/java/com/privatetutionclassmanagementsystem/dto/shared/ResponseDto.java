package com.privatetutionclassmanagementsystem.dto.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseDto {
    private Boolean validity = true;
    private String code;
    private String message;
    private Object resultData;
    private Object errorData;
}

