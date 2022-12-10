package com.privatetutionclassmanagementsystem.repository.classroom;

import com.privatetutionclassmanagementsystem.entity.classroom.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Classroom findByClassroomCode(String classroomCode);
    List<Classroom> findAllByIsAvailable(boolean isAvailable);
    List<Classroom> findAllByIsAC(boolean isAC);
    List<Classroom> findAllByIsAvailableAndIsAC(boolean isAvailable, boolean isAC);
    Classroom getByClassroomId(Long id);
}
