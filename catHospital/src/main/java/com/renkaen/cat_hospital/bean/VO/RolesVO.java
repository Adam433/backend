package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolesVO {
    public RolesVO(Roles roles){
        id = roles.getRoleId();
        katagaki = roles.getKatagaki();
        key = roles.getRoleId();
        roleName = roles.getRoleName();
    }
    private Integer id;
    private String katagaki;
    private Integer key;
    private String roleName;
}
