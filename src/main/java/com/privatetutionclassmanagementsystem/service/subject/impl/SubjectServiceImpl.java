package com.privatetutionclassmanagementsystem.service.subject.impl;

import com.privatetutionclassmanagementsystem.dto.subject.SubjectDto;
import com.privatetutionclassmanagementsystem.dto.subject.SubjectUpdateDto;
import com.privatetutionclassmanagementsystem.entity.subject.Subject;
import com.privatetutionclassmanagementsystem.repository.subject.SubjectRepository;
import com.privatetutionclassmanagementsystem.service.subject.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject createSubjectRecord(SubjectDto subjectDto){
        Subject subject = new Subject();
        modelMapper.map(subjectDto, subject);
        Subject savedSubject = subjectRepository.save(subject);
        return savedSubject;
    }

    @Override
    public List<Subject> getAllSubjectRecords(boolean isAvailable) {
        List<Subject> subjectList = subjectRepository.findAllByIsAvailable(isAvailable);
        return subjectList;
    }

    @Override
    public Subject updateSubjectRecord(String subjectCode, SubjectUpdateDto subjectUpdateDto) throws Exception {
        Subject extSubject = findBySubjectCode(subjectCode);
        if(extSubject == null){
            throw new Exception("Subject Code Doesn't Exist");
        }

        if(subjectUpdateDto.getSubjectCode() != null) extSubject.setSubjectCode(subjectUpdateDto.getSubjectCode());
        if(subjectUpdateDto.getDescription() != null) extSubject.setDescription(subjectUpdateDto.getDescription());
        if(subjectUpdateDto.getIsAvailable() != null) extSubject.setIsAvailable(subjectUpdateDto.getIsAvailable());
        if(subjectUpdateDto.getIcon() != null) extSubject.setIcon(subjectUpdateDto.getIcon());
        extSubject.setModifiedBy(subjectUpdateDto.getModifiedBy());

        Subject savedSubject = subjectRepository.save(extSubject);
        return savedSubject;
    }

    @Override
    public void deleteSubjectRecord(String subjectCode) throws Exception {
        Subject extSubject = findBySubjectCode(subjectCode);
        if(extSubject == null){
            throw new Exception("Subject Code Doesn't Exist");
        }

        subjectRepository.deleteById(extSubject.getSubjectId());
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.getBySubjectId(id);
    }

    private Subject findBySubjectCode(String subjectCode){
        return subjectRepository.findBySubjectCode(subjectCode);
    }
}
