package com.enums;

public enum EnumCallCategory {
    Local("1"),
    Roaming("2");


    private final String callCategory;

    private EnumCallCategory(String  callCategory) {
        this.callCategory = callCategory;
    }
}
