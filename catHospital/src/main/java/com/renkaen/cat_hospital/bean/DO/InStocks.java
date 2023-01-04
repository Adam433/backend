package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;

@Data
public class InStocks {
    private Integer id;
    private Integer type;
    private String namae;
    private Long keyTime;
    private Integer consumed;
    private Double sellPrice;
    private String brand;
    private Integer amount;
}
