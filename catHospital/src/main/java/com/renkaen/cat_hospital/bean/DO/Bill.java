package com.renkaen.cat_hospital.bean.DO;

import com.renkaen.cat_hospital.bean.VO.BillVO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bill {
    public Bill(BillVO billVO) {
        billId = billVO.getId();
        usage = billVO.getUsage();
        name = billVO.getName();
        sellPrice = billVO.getSellPrice();
        recordId = billVO.getRecordId();
    }

    private Integer billId;
    private Integer usage;
    private String name;
    private Double sellPrice;
    private Integer recordId;
}
