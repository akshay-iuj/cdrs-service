package com.cdrs.api.service;

import com.cdrs.api.models.CdrsDbDetails;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ICdrsService {
    List<CdrsDbDetails> getTotalDurationPerDay(String inputDate);

    List<CdrsDbDetails> getTotalVolumePerDay(String inputDate);
    List<CdrsDbDetails> getHighestChargePerDay();
    CdrsDbDetails getLongestDurationANUM();
}
