package com.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;



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
