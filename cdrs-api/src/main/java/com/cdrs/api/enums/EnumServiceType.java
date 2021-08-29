package com.cdrs.api.enums;

public enum EnumServiceType {
    Voice(1),
    SMS(2),
    GPRS(3);


    public int getServiceType() {
        return serviceType;
    }

    public static String getNameByServiceType(int serviceType){
        for(EnumServiceType e : EnumServiceType.values()){
            if(serviceType == e.serviceType) return e.name();
        }
        return null;
    }
    private final int  serviceType;

    private EnumServiceType(int  serviceType) {
        this.serviceType = serviceType;
    }
}
