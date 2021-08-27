package com.cdrs.parser.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({ "ANUM", "BNUM",  "ServiceType","CallCategory","SubscriberType","StartDatetime","UsedAmount"})
public class CdrsFileDetails {
        public String ANUM;
        public String BNUM;
        public String ServiceType;
        public String CallCategory;
        public String SubscriberType;
        public String StartDatetime;
        public String UsedAmount;
}
