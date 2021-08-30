package com.cdrs.api.payload.response;

public class ChargePerHourPerDay {
    private String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHH24() {
        return HH24;
    }

    public void setHH24(String HH24) {
        this.HH24 = HH24;
    }

    public String getCharge() {
        return Charge;
    }

    public void setCharge(String charge) {
        Charge = charge;
    }

    private String HH24;
    private String Charge;
}
