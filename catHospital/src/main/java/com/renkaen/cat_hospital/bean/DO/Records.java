package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;

@Data
public class Records {
    private Integer recordId;
    private Integer catId;
    private Long key;
    private Integer staffId;
    private String weight;
    private String diagnosis;
    private Integer reserve;
    private Integer billStatus;
}
