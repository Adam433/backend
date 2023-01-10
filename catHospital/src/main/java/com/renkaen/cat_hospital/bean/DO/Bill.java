package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bill {
    private Integer billId;
    private Integer usage;
    private String name;
    private Double sellPrice;
    private Integer recordId;
}
