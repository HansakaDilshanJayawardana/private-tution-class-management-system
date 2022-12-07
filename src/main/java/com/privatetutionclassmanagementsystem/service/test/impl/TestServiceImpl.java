package com.privatetutionclassmanagementsystem.service.test.impl;

import com.privatetutionclassmanagementsystem.dto.test.TestRequestDto;
import com.privatetutionclassmanagementsystem.entity.test.Test;
import com.privatetutionclassmanagementsystem.repository.test.TestRepository;
import com.privatetutionclassmanagementsystem.service.test.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TestRepository testRepository;

    @Override
    public Test createTestRecord(TestRequestDto testRequest){
        Test test = new Test();
        modelMapper.map(testRequest, test);
        Test savedTest = testRepository.save(test);
        return savedTest;
    }
}
