package com.privatetutionclassmanagementsystem.service.test;


import com.privatetutionclassmanagementsystem.dto.test.TestRequestDto;
import com.privatetutionclassmanagementsystem.entity.test.Test;


public interface TestService {
    Test createTestRecord(TestRequestDto testRequest);
}
