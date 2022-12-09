package com.privatetutionclassmanagementsystem.service.subject;

import com.privatetutionclassmanagementsystem.dto.subject.SubjectDto;
import com.privatetutionclassmanagementsystem.dto.subject.SubjectUpdateDto;
import com.privatetutionclassmanagementsystem.entity.subject.Subject;

import java.util.List;

public interface SubjectService {
    Subject createSubjectRecord(SubjectDto subjectDto);
    List<Subject> getAllSubjectRecords(boolean isAvailable);
    Subject updateSubjectRecord(String subjectCode, SubjectUpdateDto subjectUpdateDto) throws Exception;
    void deleteSubjectRecord(String subjectCode) throws Exception;
    Subject findById(Long id);
}
