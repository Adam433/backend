package com.renkaen.cat_hospital.bean.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InStocksVO {
    private Integer id;
    private Integer type;
    private String name;
    private Long key;
    private Integer consumed;
    private Double sellPrice;
    private String brand;
    private Integer amount;
}
