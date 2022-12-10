package com.privatetutionclassmanagementsystem.service.classroom;

import com.privatetutionclassmanagementsystem.dto.classroom.ClassroomDto;
import com.privatetutionclassmanagementsystem.dto.classroom.ClassroomUpdateDto;
import com.privatetutionclassmanagementsystem.entity.classroom.Classroom;

import java.util.List;

public interface ClassroomService {
    Classroom createClassroomRecord(ClassroomDto classroomDto);
    List<Classroom> getAllAvailableClassroomRecords(boolean isAvailable);
    List<Classroom> getAllACClassroomRecords(boolean isAC);
    List<Classroom> getAllAvailableACClassroomRecords(boolean isAvailable, boolean isAC);
    Classroom updateClassroomRecord(String classroomCode, ClassroomUpdateDto classroomUpdateDto) throws Exception;
    void deleteClassroomRecord(String classroomCode) throws Exception;
    Classroom findById(Long id);
}
