package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Bill;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BillVO {
    public BillVO(Bill bill){
        id = bill.getBillId();
        usage = bill.getUsage();
        key = bill.getBillId();;
        name = bill.getName();
        sellPrice = bill.getSellPrice();
        recordId = bill.getRecordId();
    }
    private Integer id;
    private Integer usage;
    private Integer key;
    private String name;
    private Double sellPrice;
    private Integer recordId;
}
