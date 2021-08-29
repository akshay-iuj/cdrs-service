package com.cdrs.api.controllers;


import com.cdrs.api.models.CdrsDbDetails;
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
        List<CdrsDbDetails> dbData=cdrsService.getHighestChargePerDayByANUM();
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
    public ResponseEntity<?> getServiceTypeByMaxChargePerDay(@Valid @RequestBody Date inputDate)  {
        return ResponseEntity.ok("");
    }


    @GetMapping("/getChargePerHourByDay")
    public ResponseEntity<?> getChargePerHourByDay(@Valid @RequestBody Date inputDate)  {
        return ResponseEntity.ok("");
    }



}