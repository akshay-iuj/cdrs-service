package com.cdrs.api.utils;

import com.cdrs.api.enums.EnumCallCategory;
import com.cdrs.api.enums.EnumServiceType;
import com.cdrs.api.enums.EnumSubscriberType;
import com.cdrs.api.models.CdrsDbDetails;
import com.cdrs.api.models.CdrsFileDetails;
import com.cdrs.api.models.CdrsOutputFileDetails;

import java.util.*;
import java.util.stream.Collectors;

public class CdrsOutputGenerator {
    public static List<CdrsOutputFileDetails> fileGenerator(List<CdrsDbDetails> inputData)
    {
        List<CdrsDbDetails> sortedInputData = inputData.stream()
                .sorted(Comparator.comparing(CdrsDbDetails::getCharge))
                .collect(Collectors.toList());
        List<CdrsOutputFileDetails> outputData=new ArrayList<>();
        for (CdrsDbDetails dbData: sortedInputData) {
            CdrsOutputFileDetails data=new CdrsOutputFileDetails();
            data.ANUM=dbData.getANUM();
            data.BNUM=dbData.getBNUM();
            data.ServiceType= EnumServiceType.getNameByServiceType(dbData.getServiceType());
            data.SubscriberType= EnumSubscriberType.getNameByServiceType(dbData.getSubscriberType());
            data.CallCategory= EnumCallCategory.getNameByServiceType(dbData.getCallCategory());
            data.UsedAmount= String.valueOf(dbData.getUsedAmount());
            data.Charge=String.valueOf(dbData.getCharge());
            outputData.add(data);
        }

        return outputData;
    }

}
