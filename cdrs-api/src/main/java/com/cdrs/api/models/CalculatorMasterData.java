package com.cdrs.api.models;

import javax.persistence.*;

@Entity
@Table(	name = "CalculatorMasterData")
public class CalculatorMasterData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int ServiceType;

    public int getServiceType() {
        return ServiceType;
    }

    public int getCallCategory() {
        return CallCategory;
    }

    public int getSubscriberType() {
        return SubscriberType;
    }

    public double getChargePerUnit() {
        return ChargePerUnit;
    }

    @Column(nullable = false)
    private int CallCategory;

    @Column(nullable = false)
    private int SubscriberType;

    @Column(nullable = false)
    private double ChargePerUnit;


}
