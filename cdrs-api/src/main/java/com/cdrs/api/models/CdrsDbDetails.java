package com.cdrs.api.models;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

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

    private int ServiceType;

    private int CallCategory;

    private int SubscriberType;

    private Timestamp StartDatetime;

    public double UsedAmount;

    public double ActualUsedAmount;

    public double getUsedAmount() {
        return UsedAmount;
    }

    public void setUsedAmount(double usedAmount) {
        UsedAmount = usedAmount;
    }

    public double getActualUsedAmount() {
        return ActualUsedAmount;
    }

    public void setActualUsedAmount(double actualUsedAmount) {
        ActualUsedAmount = actualUsedAmount;
    }

    public double getCharge() {
        return Charge;
    }

    public void setCharge(double charge) {
        Charge = charge;
    }

    public double Charge;



    @NotBlank
    @Size(max = 50)
    public String FileName;


    public CdrsDbDetails()
    { }

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

    public Timestamp getStartDatetime() {
        return StartDatetime;
    }

    public void setStartDatetime(Timestamp startDatetime) { StartDatetime = startDatetime; }

    public String getFileName() { return FileName; }

    public void setFileName(String fileName) { FileName = fileName; }
}
