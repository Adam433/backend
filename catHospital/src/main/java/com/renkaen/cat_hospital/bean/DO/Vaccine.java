package com.renkaen.cat_hospital.bean.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {
    private Integer VaccineId;
    private Integer catId;
    private Long date;
}
