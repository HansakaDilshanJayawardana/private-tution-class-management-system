package com.privatetutionclassmanagementsystem.repository.batch;

import com.privatetutionclassmanagementsystem.entity.batch.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    Batch findByBatchCode(String batchCode);
    List<Batch> findAllByIsCurrent(boolean isCurrent);
    Batch getByBatchId(Long id);
}
