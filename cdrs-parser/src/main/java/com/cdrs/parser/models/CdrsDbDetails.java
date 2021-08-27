package com.cdrs.parser.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(	name = "CdrsDetails")
public class CdrsDbDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 15)
    private String ANUM;

    @Size(max = 15)
    private String BNUM;

    @NotBlank
    @Size(max = 2)
    private int ServiceType;

    @NotBlank
    @Size(max = 2)
    private int CallCategory;

    @NotBlank
    @Size(max = 2)
    private int SubscriberType;

    @NotBlank
    private Date StartDatetime;

    public int UsedAmount;

    public int Charge;



    @NotBlank
    @Size(max = 50)
    public String FileName;


    public CdrsDbDetails()
    {

    }
    public CdrsDbDetails(String ANUM, String BNUM, int serviceType, int callCategory, int subscriberType, Date startDatetime, int usedAmount, int charge,String fileName) {
        this.ANUM = ANUM;
        this.BNUM = BNUM;
        ServiceType = serviceType;
        CallCategory = callCategory;
        SubscriberType = subscriberType;
        StartDatetime = startDatetime;
        UsedAmount = usedAmount;
        Charge = charge;
        FileName=fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getANUM() {
        return ANUM;
    }

    public void setANUM(String ANUM) {
        this.ANUM = ANUM;
    }

    public String getBNUM() {
        return BNUM;
    }

    public void setBNUM(String BNUM) {
        this.BNUM = BNUM;
    }

    public int getServiceType() {
        return ServiceType;
    }

    public void setServiceType(int serviceType) {
        ServiceType = serviceType;
    }

    public int getCallCategory() {
        return CallCategory;
    }

    public void setCallCategory(int callCategory) {
        CallCategory = callCategory;
    }

    public int getSubscriberType() {
        return SubscriberType;
    }

    public void setSubscriberType(int subscriberType) {
        SubscriberType = subscriberType;
    }

    public Date getStartDatetime() {
        return StartDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        StartDatetime = startDatetime;
    }

    public int getUsedAmount() {
        return UsedAmount;
    }

    public void setUsedAmount(int usedAmount) {
        UsedAmount = usedAmount;
    }

    public int getCharge() {
        return Charge;
    }

    public void setCharge(int charge) {
        Charge = charge;
    }

    public String getFileName() { return FileName; }

    public void setFileName(String fileName) { FileName = fileName; }
}
