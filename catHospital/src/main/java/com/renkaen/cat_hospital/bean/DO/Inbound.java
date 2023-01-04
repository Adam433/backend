package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Inbound {
    private Integer id;
    private Long keyTime;
    private Integer amount;
    private String batchNumber;
    private String staff;
    private Double purchasePrice;
    private Integer inStockId;
}
