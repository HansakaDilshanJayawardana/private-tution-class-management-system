package com.privatetutionclassmanagementsystem.service.batch;

import com.privatetutionclassmanagementsystem.dto.batch.BatchDto;
import com.privatetutionclassmanagementsystem.dto.batch.BatchUpdateDto;
import com.privatetutionclassmanagementsystem.entity.batch.Batch;

import java.util.List;

public interface BatchService {
    Batch createBatchRecord(BatchDto batchDto);
    List<Batch> getAllBatchRecords(boolean isCurrent);
    Batch updateBatchRecord(String batchCode, BatchUpdateDto batchUpdateDto) throws Exception;
    void deleteBatchRecord(String batchCode) throws Exception;
    Batch findById(Long id);
}
