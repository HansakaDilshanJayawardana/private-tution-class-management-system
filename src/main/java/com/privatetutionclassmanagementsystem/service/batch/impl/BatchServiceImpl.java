package com.privatetutionclassmanagementsystem.service.batch.impl;

import com.privatetutionclassmanagementsystem.dto.batch.BatchDto;
import com.privatetutionclassmanagementsystem.dto.batch.BatchUpdateDto;
import com.privatetutionclassmanagementsystem.entity.batch.Batch;
import com.privatetutionclassmanagementsystem.repository.batch.BatchRepository;
import com.privatetutionclassmanagementsystem.service.batch.BatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public Batch createBatchRecord(BatchDto batchDto){
        Batch batch = new Batch();
        modelMapper.map(batchDto, batch);
        Batch savedSubject = batchRepository.save(batch);
        return savedSubject;
    }

    @Override
    public List<Batch> getAllBatchRecords(boolean isCurrent) {
        List<Batch> batchList = batchRepository.findAllByIsCurrent(isCurrent);
        return batchList;
    }

    @Override
    public Batch updateBatchRecord(String batchCode, BatchUpdateDto batchUpdateDto) throws Exception {
        Batch extBatch = findByBatchCode(batchCode);
        if(extBatch == null){
            throw new Exception("Batch Code Doesn't Exist");
        }

        if(batchUpdateDto.getBatchCode() != null) extBatch.setBatchCode(batchUpdateDto.getBatchCode());
        if(batchUpdateDto.getBatchName() != null) extBatch.setBatchName(batchUpdateDto.getBatchName());
        if(batchUpdateDto.getIsCurrent() != null) extBatch.setIsCurrent(batchUpdateDto.getIsCurrent());
        extBatch.setModifiedBy(batchUpdateDto.getModifiedBy());

        Batch savedBatch = batchRepository.save(extBatch);
        return savedBatch;
    }

    @Override
    public void deleteBatchRecord(String batchCode) throws Exception {
        Batch extBatch = findByBatchCode(batchCode);
        if(extBatch == null){
            throw new Exception("Batch Code Doesn't Exist");
        }

        batchRepository.deleteById(extBatch.getBatchId());
    }

    @Override
    public Batch findById(Long id) {
        return batchRepository.getByBatchId(id);
    }

    private Batch findByBatchCode(String batchCode){
        return batchRepository.findByBatchCode(batchCode);
    }
}
