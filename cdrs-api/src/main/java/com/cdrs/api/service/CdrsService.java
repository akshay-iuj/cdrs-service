package com.cdrs.api.service;

import com.cdrs.api.models.CdrsDbDetails;
import com.cdrs.api.repository.CdrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CdrsService implements  ICdrsService{

    @Autowired
    private CdrsRepository cdrsRepository;

    @Override
    public List<CdrsDbDetails> getTotalDurationPerDay(String inputDate) {
        return cdrsRepository.getTotalDurationPerDay(inputDate);
    }

    @Override
    public List<CdrsDbDetails> getTotalVolumePerDay(String inputDate) {
        return cdrsRepository.getTotalVolumePerDay(inputDate);
    }

    @Override
    public List<CdrsDbDetails> getHighestChargePerDay() {
        return cdrsRepository.getHighestChargePerDay();
    }

    @Override
    public CdrsDbDetails getLongestDurationANUM() {
      return cdrsRepository.getLongestDurationANUM();
    }

}
