package com.cdrs.api.enums;

public enum EnumCallCategory {
    Local(1),
    Roaming(2);


    private final int callCategory;

    private EnumCallCategory(int callCategory) {
        this.callCategory = callCategory;
    }

    public static String getNameByServiceType(int callCategory) {
        for(EnumCallCategory e : EnumCallCategory.values()){
            if(callCategory == e.callCategory) return e.name();
        }
        return null;
    }
}
