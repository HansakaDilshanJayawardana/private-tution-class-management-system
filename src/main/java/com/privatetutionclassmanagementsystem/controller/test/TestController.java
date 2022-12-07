package com.privatetutionclassmanagementsystem.controller.test;

import com.privatetutionclassmanagementsystem.dto.shared.ResponseDto;
import com.privatetutionclassmanagementsystem.dto.test.TestRequestDto;
import com.privatetutionclassmanagementsystem.entity.test.Test;
import com.privatetutionclassmanagementsystem.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity testPostMethod(@RequestBody TestRequestDto testRequest){
        ResponseDto responseDto = new ResponseDto();
        try{
            Test test = testService.createTestRecord(testRequest);
            responseDto.setMessage("Test Record Creation Succeeded!");
            responseDto.setCode("001");
            responseDto.setResultData(test);
            // responseDto.setResultData(test);
        }catch (Exception e){
            responseDto.setMessage("Test Record Creation Failed!");
            responseDto.setCode("002");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }
}
