package com.amsa.proxy.viewModel.columbiasc;

import lombok.Data;

@Data
public class ParentContact {
    private Integer idNumber;
    private String fatherLastName;
    private String fatherFirstName;
    private String fatherMiddleName;
    private String fatherEmail;
    private String fatherAddrLine2;
    private String fatherAddrLine3;
    private String fatherCity;
    private String fatherState;
    private String fatherPostalCode;
    private String fatherPhone;

    private String motherLastName;
    private String motherFirstName;
    private String motherMiddleName;
    private String motherEmail;
    private String motherAddrLine2;
    private String motherAddrLine3;
    private String motherCity;
    private String motherState;
    private String motherPostalCode;
    private String motherPhone;
}


