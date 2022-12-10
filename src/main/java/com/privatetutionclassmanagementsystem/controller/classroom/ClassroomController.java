package com.privatetutionclassmanagementsystem.controller.classroom;

import com.privatetutionclassmanagementsystem.dto.batch.BatchDto;
import com.privatetutionclassmanagementsystem.dto.batch.BatchUpdateDto;
import com.privatetutionclassmanagementsystem.dto.classroom.ClassroomDto;
import com.privatetutionclassmanagementsystem.dto.classroom.ClassroomUpdateDto;
import com.privatetutionclassmanagementsystem.dto.shared.ResponseDto;
import com.privatetutionclassmanagementsystem.entity.batch.Batch;
import com.privatetutionclassmanagementsystem.entity.classroom.Classroom;
import com.privatetutionclassmanagementsystem.service.batch.BatchService;
import com.privatetutionclassmanagementsystem.service.classroom.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("classroom")
@CrossOrigin("*")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @RequestMapping(path = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody @Valid ClassroomDto classroomDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            Classroom classroom = classroomService.createClassroomRecord(classroomDto);
            responseDto.setMessage("Classroom Creation Succeeded!");
            responseDto.setCode("019");
            responseDto.setResultData(classroom);
        }catch (Exception e){
            responseDto.setMessage("Classroom Creation Failed!");
            responseDto.setCode("020");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/getAllAvailableClassrooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAvailableClassrooms(@RequestParam boolean isAvailable){
        ResponseDto responseDto = new ResponseDto();
        try{
            List<Classroom> classroomList = classroomService.getAllAvailableClassroomRecords(isAvailable);
            responseDto.setMessage("Available Classrooms Retrieval Succeeded!");
            responseDto.setCode("021");
            responseDto.setResultData(classroomList);
        }catch (Exception e){
            responseDto.setMessage("Available Classroom Retrieval Failed!");
            responseDto.setCode("022");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/getAllACClassrooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllACClassrooms(@RequestParam boolean isAC){
        ResponseDto responseDto = new ResponseDto();
        try{
            List<Classroom> classroomList = classroomService.getAllACClassroomRecords(isAC);
            responseDto.setMessage("AC Classrooms Retrieval Succeeded!");
            responseDto.setCode("023");
            responseDto.setResultData(classroomList);
        }catch (Exception e){
            responseDto.setMessage("AC Classroom Retrieval Failed!");
            responseDto.setCode("024");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/getAllAvailableACClassrooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAvailableACClassrooms(@RequestParam boolean isAvailable, @RequestParam boolean isAC){
        ResponseDto responseDto = new ResponseDto();
        try{
            List<Classroom> classroomList = classroomService.getAllAvailableACClassroomRecords(isAvailable, isAC);
            responseDto.setMessage("Available AC Classrooms Retrieval Succeeded!");
            responseDto.setCode("025");
            responseDto.setResultData(classroomList);
        }catch (Exception e){
            responseDto.setMessage("Available AC Classroom Retrieval Failed!");
            responseDto.setCode("026");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestParam String classroomCode,
                                 @RequestBody ClassroomUpdateDto classroomUpdateDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            Classroom classroom = classroomService.updateClassroomRecord(classroomCode, classroomUpdateDto);
            responseDto.setMessage("Classroom Update Succeeded!");
            responseDto.setCode("027");
            responseDto.setResultData(classroom);
        }catch (Exception e){
            responseDto.setMessage("Classroom Update Failed!");
            responseDto.setCode("028");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@RequestParam String classroomCode){
        ResponseDto responseDto = new ResponseDto();
        try{
            classroomService.deleteClassroomRecord(classroomCode);
            responseDto.setMessage("Classroom Deletion Succeeded!");
            responseDto.setCode("029");
        }catch (Exception e){
            responseDto.setMessage("Classroom Deletion Failed!");
            responseDto.setCode("030");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }
}
