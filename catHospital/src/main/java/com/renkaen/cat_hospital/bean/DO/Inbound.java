package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Inbound {
    private Integer inboundId;
    private Long key;
    private Integer amount;
    private String batchNumber;
    private String staff;
    private Double purchasePrice;
    private Integer inStockId;
}
