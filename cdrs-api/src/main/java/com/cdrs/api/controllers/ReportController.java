package com.cdrs.api.controllers;


import com.cdrs.api.models.CdrsDbDetails;
import com.cdrs.api.payload.response.ChargePerHourPerDay;
import com.cdrs.api.payload.response.HighestServiceCharge;
import com.cdrs.api.payload.response.MessageResponse;
import com.cdrs.api.repository.CdrsRepository;
import com.cdrs.api.service.CdrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/report")
public class ReportController {


    @Autowired
    CdrsService cdrsService;
    @Autowired
    CdrsRepository cdrsRepository;



    @GetMapping("/getTotalDurationPerDay")
    public ResponseEntity<?> getTotalDurationPerDay(@Valid @RequestParam String inputDate)  {
        List<CdrsDbDetails> dbData=cdrsService.getTotalDurationPerDay(inputDate);
        Double sumOtTotalDuration=dbData.stream()
                .mapToDouble(i -> i.UsedAmount)
                .sum();

        return ResponseEntity.ok(new MessageResponse(sumOtTotalDuration.toString()+"minutes"));
    }

    @GetMapping("/getTotalVolumeByDay")
    public ResponseEntity<?> getTotalVolumeByDay(@Valid @RequestParam String inputDate)  {
        List<CdrsDbDetails> dbData=cdrsService.getTotalVolumePerDay(inputDate);
        Double sumOtTotalVolume=dbData.stream()
                .mapToDouble(i -> i.UsedAmount)
                .sum();

        return ResponseEntity.ok(new MessageResponse(sumOtTotalVolume.toString()+"MB"));
    }

    @GetMapping("/getLongestDurationANUM")
    public ResponseEntity<?> getLongestDurationANUM()  {
        return ResponseEntity.ok(new MessageResponse(cdrsService.getLongestDurationANUM().getANUM()));
    }


    @GetMapping("/getHighestChargePerDayByANUM")
    public ResponseEntity<?> getHighestChargePerDayByANUM()  {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        List<CdrsDbDetails> dbData=cdrsService.getHighestChargePerDay();
        Map<String, String> anumMap  = new HashMap<String, String>() ;
        for (CdrsDbDetails dbrecord:dbData) {
            anumMap.put(df.format(dbrecord.getStartDatetime()),dbrecord.getANUM());
        }
        return ResponseEntity.ok(anumMap);
    }

    @GetMapping("/getTotalDurationForEachCallCategoryForVoice")
    public ResponseEntity<?> getTotalDurationForEachCallCategoryForVoice()  {
         return ResponseEntity.ok(cdrsRepository.getTotalDurationForEachCallCategoryForVoice());
    }

    @GetMapping("/getTotalVolumeForEachSubscriberTypeForGPRS")
    public ResponseEntity<?> getTotalVolumeForEachSubscriberTypeForGPRS()  {
        return ResponseEntity.ok(cdrsRepository.getTotalVolumeForEachSubscriberTypeForGPRS());
    }

    @GetMapping("/getServiceTypeByMaxChargePerDay")
    public ResponseEntity<?> getServiceTypeByMaxChargePerDay()  {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        List<CdrsDbDetails> dbData=cdrsService.getHighestChargePerDay();
        List<HighestServiceCharge> maxServiceChargesList  = new ArrayList<>() ;
        for (CdrsDbDetails dbRecord:dbData) {
            HighestServiceCharge maxServiceCharges=new HighestServiceCharge();
            maxServiceCharges.setCharge(String.valueOf(dbRecord.getCharge()));
            maxServiceCharges.setDate(df.format(dbRecord.getStartDatetime()));
            maxServiceCharges.setServiceType(String.valueOf(dbRecord.getServiceType()));
            maxServiceChargesList.add(maxServiceCharges);
        }
        return ResponseEntity.ok(maxServiceChargesList);
    }


    @GetMapping("/getChargePerHourByDay")
    public ResponseEntity<?> getChargePerHourByDay()  {
        String pattern = "yyyy-MM-dd";
        String pattern2="HH:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        DateFormat df2 = new SimpleDateFormat(pattern2);
        List<CdrsDbDetails> dbData=cdrsService.getHighestChargePerDay();
        List<ChargePerHourPerDay> maxServiceChargesList  = new ArrayList<>() ;
        for (CdrsDbDetails dbRecord:dbData) {
            ChargePerHourPerDay maxServiceCharges=new ChargePerHourPerDay();
            maxServiceCharges.setCharge(String.valueOf(dbRecord.getCharge()));
            maxServiceCharges.setDate(df.format(dbRecord.getStartDatetime()));
            maxServiceCharges.setHH24(df2.format(dbRecord.getStartDatetime()));
            maxServiceChargesList.add(maxServiceCharges);
        }
        return ResponseEntity.ok(maxServiceChargesList);
    }



}