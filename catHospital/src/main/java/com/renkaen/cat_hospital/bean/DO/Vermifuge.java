package com.renkaen.cat_hospital.bean.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vermifuge {
    private Integer vermifugeId;
    private Integer catId;
    private Long date;
}
