package com.privatetutionclassmanagementsystem.repository.subject;

import com.privatetutionclassmanagementsystem.entity.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectCode(String subjectCode);
    List<Subject> findAllByIsAvailable(boolean isAvailable);
    Subject getBySubjectId(Long id);
}
