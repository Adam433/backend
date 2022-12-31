package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.PO.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolesVO {
    public RolesVO(Roles roles){
        id = roles.getId();
        katagaki = roles.getKatagaki();
        key = roles.getKeyTime();
    }
    private Integer id;
    private String katagaki;
    private Integer key;
}
