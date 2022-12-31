package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.PO.Inbound;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class InStocksJoinInboundVO {
    private Integer id;
    private Integer type;
    private String name;
    private Long key;
    private Integer consumed;
    private Double sellPrice;
    private String brand;
    private Integer amount;
    private List<InboundVO> inbound;
}
