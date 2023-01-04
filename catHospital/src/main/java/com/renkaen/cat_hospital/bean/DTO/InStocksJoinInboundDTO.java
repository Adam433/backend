package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.DO.Inbound;
import lombok.Data;

import java.util.List;
@Data
public class InStocksJoinInboundDTO {
    private Integer id;
    private Integer type;
    private String namae;
    private Long keyTime;
    private Integer consumed;
    private Double sellPrice;
    private String brand;
    private Integer amount;
    private List<Inbound> inbound;
}
