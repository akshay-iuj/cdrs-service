package com.cdrs.api.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({ "ANUM", "BNUM",  "ServiceType","CallCategory","SubscriberType","StartDatetime","UsedAmount"})
public class CdrsInputFileDetails extends CdrsFileDetails{
        public String StartDatetime;
}
