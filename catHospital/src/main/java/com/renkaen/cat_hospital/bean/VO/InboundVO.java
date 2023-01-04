package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Inbound;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InboundVO {
    public InboundVO(Inbound inbound){
        id = inbound.getId();
        key = inbound.getKeyTime();
        amount = inbound.getAmount();
        batchNumber = inbound.getBatchNumber();
        staff = inbound.getStaff();
        purchasePrice = inbound.getPurchasePrice();
        inStockId = inbound.getInStockId();
    }
    private Integer id;
    private Long key;
    private Integer amount;
    private String batchNumber;
    private String staff;
    private Double purchasePrice;
    private Integer inStockId;
}
