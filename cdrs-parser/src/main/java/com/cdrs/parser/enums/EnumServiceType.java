package com.cdrs.parser.enums;

public enum EnumServiceType {
    Voice("1"),
    SMS("2"),
    GPRS("3");


    private final String  serviceType;

    private EnumServiceType(String  serviceType) {
        this.serviceType = serviceType;
    }
}
