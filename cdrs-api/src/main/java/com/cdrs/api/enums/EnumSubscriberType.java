package com.cdrs.api.enums;

public enum EnumSubscriberType {
    Postpaid(1) ,
    Prepaid(2);


    private final int subscriberType;

    private EnumSubscriberType(int subscriberType) {
        this.subscriberType = subscriberType;
    }

    public static String getNameByServiceType(int subscriberType) {
        for(EnumSubscriberType e : EnumSubscriberType.values()){
            if(subscriberType == e.subscriberType) return e.name();
        }
        return null;
    }
}
