package com.renkaen.cat_hospital.bean.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treatment {
    private Integer treatmentId;
    private Integer recordId;
    private Integer inStockId;
    private Integer usage;
    private Boolean done;
}
