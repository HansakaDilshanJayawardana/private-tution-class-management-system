package com.privatetutionclassmanagementsystem.controller.batch;

import com.privatetutionclassmanagementsystem.dto.batch.BatchDto;
import com.privatetutionclassmanagementsystem.dto.batch.BatchUpdateDto;
import com.privatetutionclassmanagementsystem.dto.shared.ResponseDto;
import com.privatetutionclassmanagementsystem.entity.batch.Batch;
import com.privatetutionclassmanagementsystem.service.batch.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("batch")
@CrossOrigin("*")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @RequestMapping(path = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody @Valid BatchDto batchDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            Batch batch = batchService.createBatchRecord(batchDto);
            responseDto.setMessage("Batch Creation Succeeded!");
            responseDto.setCode("009");
            responseDto.setResultData(batch);
        }catch (Exception e){
            responseDto.setMessage("Batch Creation Failed!");
            responseDto.setCode("010");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(@RequestParam boolean isCurrent){
        ResponseDto responseDto = new ResponseDto();
        try{
            List<Batch> batchList = batchService.getAllBatchRecords(isCurrent);
            responseDto.setMessage("Batches Retrieval Succeeded!");
            responseDto.setCode("011");
            responseDto.setResultData(batchList);
        }catch (Exception e){
            responseDto.setMessage("Batches Retrieval Failed!");
            responseDto.setCode("012");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestParam String batchCode,
                                 @RequestBody BatchUpdateDto batchUpdateDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            Batch batch = batchService.updateBatchRecord(batchCode, batchUpdateDto);
            responseDto.setMessage("Batch Update Succeeded!");
            responseDto.setCode("013");
            responseDto.setResultData(batch);
        }catch (Exception e){
            responseDto.setMessage("Batch Update Failed!");
            responseDto.setCode("014");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@RequestParam String batchCode){
        ResponseDto responseDto = new ResponseDto();
        try{
            batchService.deleteBatchRecord(batchCode);
            responseDto.setMessage("Batch Deletion Succeeded!");
            responseDto.setCode("015");
        }catch (Exception e){
            responseDto.setMessage("Batch Deletion Failed!");
            responseDto.setCode("016");
            responseDto.setValidity(false);
            responseDto.setErrorData(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }
}
