package com.privatetutionclassmanagementsystem.controller.subject;

import com.privatetutionclassmanagementsystem.dto.shared.ResponseDto;
import com.privatetutionclassmanagementsystem.dto.subject.SubjectDto;
import com.privatetutionclassmanagementsystem.dto.subject.SubjectUpdateDto;
import com.privatetutionclassmanagementsystem.entity.subject.Subject;
import com.privatetutionclassmanagementsystem.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("subject")
@CrossOrigin("*")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(path = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody @Valid SubjectDto subjectDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            Subject subject = subjectService.createSubjectRecord(subjectDto);
            responseDto.setMessage("Subject Creation Succeeded!");
            responseDto.setCode("003");
            responseDto.setResultData(subject);
        }catch (Exception e){
            responseDto.setMessage("Subject Creation Failed!");
            responseDto.setCode("004");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(@RequestParam boolean isAvailable){
        ResponseDto responseDto = new ResponseDto();
        try{
            List<Subject> subjectList = subjectService.getAllSubjectRecords(isAvailable);
            responseDto.setMessage("Subjects Retrieval Succeeded!");
            responseDto.setCode("005");
            responseDto.setResultData(subjectList);
        }catch (Exception e){
            responseDto.setMessage("Subjects Retrieval Failed!");
            responseDto.setCode("006");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestParam String subjectCode,
                                 @RequestBody SubjectUpdateDto subjectUpdateDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            Subject subject = subjectService.updateSubjectRecord(subjectCode, subjectUpdateDto);
            responseDto.setMessage("Subject Update Succeeded!");
            responseDto.setCode("007");
            responseDto.setResultData(subject);
        }catch (Exception e){
            responseDto.setMessage("Subject Update Failed!");
            responseDto.setCode("008");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@RequestParam String subjectCode){
        ResponseDto responseDto = new ResponseDto();
        try{
            subjectService.deleteSubjectRecord(subjectCode);
            responseDto.setMessage("Subject Deletion Succeeded!");
            responseDto.setCode("009");
        }catch (Exception e){
            responseDto.setMessage("Subject Deletion Failed!");
            responseDto.setCode("010");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }
}
