package com.cdrs.parser.enums;

public enum EnumSubscriberType {
    Postpaid("1") ,
    Prepaid("2");


    private final String subscriberType;

    private EnumSubscriberType(String subscriberType) {
        this.subscriberType = subscriberType;
    }
}
