package com.cdrs.api.utils;

import com.cdrs.api.enums.EnumServiceType;
import com.cdrs.api.models.CalculatorMasterData;
import com.cdrs.api.models.CdrsDbDetails;
import com.cdrs.api.models.CdrsInputFileDetails;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class CdrsFileToDbConverter
{
    public static List<CdrsDbDetails> mapper(List<CdrsInputFileDetails> details, String fileName, List<CalculatorMasterData> chargePerUnit) throws ParseException
    {
        List<CdrsDbDetails> dbListData=new ArrayList<>();
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        for (CdrsInputFileDetails data: details) {
            CdrsDbDetails dbData=new CdrsDbDetails();
            dbData.setANUM(data.ANUM);
            dbData.setBNUM(normalise_bnum(data.BNUM));
            dbData.setServiceType((data.ServiceType==null || data.ServiceType=="")?0:Integer.parseInt(data.ServiceType));
            dbData.setCallCategory((data.CallCategory==null || data.CallCategory=="")?0:Integer.parseInt(data.CallCategory));
            dbData.setSubscriberType((data.SubscriberType==null || data.SubscriberType=="")?0:Integer.parseInt(data.SubscriberType));
            Date parsed = format.parse(data.StartDatetime);
            dbData.setStartDatetime(new java.sql.Timestamp(parsed.getTime()));
            dbData.setActualUsedAmount((data.UsedAmount==null || data.UsedAmount=="")?0:Integer.parseInt(data.UsedAmount));
            dbData.setUsedAmount(duration_converter(dbData.getActualUsedAmount(),dbData.getServiceType()));
            dbData.setCharge(charge_calculator(dbData.getUsedAmount(),dbData.getServiceType(),dbData.getCallCategory(),dbData.getSubscriberType(),chargePerUnit));
            dbData.setFileName(fileName);
            dbListData.add(dbData);
        }
        return dbListData;
    }

    private static double charge_calculator(double usedAmount, int serviceType, int callCategory, int subscriberType, List<CalculatorMasterData> chargePerUnit) {
        double charge = 0;
        for (CalculatorMasterData data: chargePerUnit) {
            if(data.getCallCategory()==callCategory && data.getServiceType()==serviceType && data.getSubscriberType()==subscriberType)
            {
            if(serviceType== EnumServiceType.SMS.getServiceType())
               charge=data.getChargePerUnit();
            else
                charge=data.getChargePerUnit()*usedAmount;
            }
        }
        return Math.round(charge*100.0)/100.0;

    }
    private static String normalise_bnum(String bnum) {
        if(bnum == null || bnum =="")
            return null;
        if (bnum.startsWith("00"))
            return  bnum.replaceFirst(Pattern.quote("00"),"");
        else if(bnum.startsWith("+"))
          return  bnum.replaceFirst(Pattern.quote("+"),"");
        return bnum;
    }

    private static double duration_converter(double usedAmount, int serviceType) {
        if(serviceType==EnumServiceType.Voice.getServiceType())
           return conversion_factor(usedAmount,60);
        else if(serviceType==EnumServiceType.GPRS.getServiceType())
          return conversion_factor(usedAmount,1024);
        else
            return 0;

    }

    private static double conversion_factor(double usedAmount, int convertRatio)
    {
        if (usedAmount % convertRatio != 0)
            return (int)(usedAmount) / convertRatio + 1;
        else
            return (int)(usedAmount) / convertRatio;
    }
}
