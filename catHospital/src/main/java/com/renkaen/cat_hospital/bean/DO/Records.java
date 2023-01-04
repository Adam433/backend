package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;

@Data
public class Records {
    private Integer id;
    private Integer catId;
    private Long keyTime;
    private Integer staffId;
    private String weight;
    private String treatments;
    private String diagnosis;
    private Integer reserve;
    private Integer bill;
    private String billList;
}
