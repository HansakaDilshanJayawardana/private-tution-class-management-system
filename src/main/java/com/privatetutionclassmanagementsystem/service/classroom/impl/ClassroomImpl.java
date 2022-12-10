package com.privatetutionclassmanagementsystem.service.classroom.impl;

import com.privatetutionclassmanagementsystem.dto.classroom.ClassroomDto;
import com.privatetutionclassmanagementsystem.dto.classroom.ClassroomUpdateDto;
import com.privatetutionclassmanagementsystem.entity.classroom.Classroom;
import com.privatetutionclassmanagementsystem.repository.classroom.ClassroomRepository;
import com.privatetutionclassmanagementsystem.service.classroom.ClassroomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomImpl implements ClassroomService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom createClassroomRecord(ClassroomDto classroomDto){
        Classroom classroom = new Classroom();
        modelMapper.map(classroomDto, classroom);
        Classroom savedClassroom = classroomRepository.save(classroom);
        return savedClassroom;
    }

    @Override
    public List<Classroom> getAllAvailableClassroomRecords(boolean isAvailable) {
        List<Classroom> classroomList = classroomRepository.findAllByIsAvailable(isAvailable);
        return classroomList;
    }

    @Override
    public List<Classroom> getAllACClassroomRecords(boolean isAC) {
        List<Classroom> classroomList = classroomRepository.findAllByIsAC(isAC);
        return classroomList;
    }

    @Override
    public List<Classroom> getAllAvailableACClassroomRecords(boolean isAvailable, boolean isAC) {
        List<Classroom> classroomList = classroomRepository.findAllByIsAvailableAndIsAC(isAvailable, isAC);
        return classroomList;
    }

    @Override
    public Classroom updateClassroomRecord(String classroomCode, ClassroomUpdateDto classroomUpdateDto) throws Exception {
        Classroom extClassroom = findByClassroomCode(classroomCode);
        if(extClassroom == null){
            throw new Exception("Classroom Code Doesn't Exist");
        }

        if(classroomUpdateDto.getClassroomCode() != null) extClassroom.setClassroomCode(classroomUpdateDto.getClassroomCode());
        if(classroomUpdateDto.getClassroomName() != null) extClassroom.setClassroomName(classroomUpdateDto.getClassroomName());
        if(classroomUpdateDto.getFloor() != null) extClassroom.setFloor(classroomUpdateDto.getFloor());
        if(classroomUpdateDto.getCapacity() != null) extClassroom.setCapacity(classroomUpdateDto.getCapacity());
        if(classroomUpdateDto.getIsAvailable() != null) extClassroom.setIsAvailable(classroomUpdateDto.getIsAvailable());
        if(classroomUpdateDto.getIsAC() != null) extClassroom.setIsAC(classroomUpdateDto.getIsAC());
        extClassroom.setModifiedBy(classroomUpdateDto.getModifiedBy());

        Classroom savedClassroom = classroomRepository.save(extClassroom);
        return savedClassroom;
    }

    @Override
    public void deleteClassroomRecord(String classroomCode) throws Exception {
        Classroom extClassroom = findByClassroomCode(classroomCode);
        if(extClassroom == null){
            throw new Exception("Classroom Code Doesn't Exist");
        }

        classroomRepository.deleteById(extClassroom.getClassroomId());
    }

    @Override
    public Classroom findById(Long id) {
        return classroomRepository.getByClassroomId(id);
    }

    private Classroom findByClassroomCode(String classroomCode){
        return classroomRepository.findByClassroomCode(classroomCode);
    }
}
