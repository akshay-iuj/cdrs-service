package com.cdrs.api.repository;
import com.cdrs.api.models.CalculatorMasterData;
import com.cdrs.api.models.CdrsDbDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculatorRepository extends JpaRepository<CalculatorMasterData,Long> {
    List<CalculatorMasterData> findAll();
}


