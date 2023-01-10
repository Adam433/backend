package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;

@Data
public class InStocks {
    private Integer inStockId;
    private Integer type;
    private String name;
    private Long key;
    private Integer consumed;
    private Double sellPrice;
    private String brand;
    private Integer amount;
}
