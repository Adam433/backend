package com.renkaen.cat_hospital.bean.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffJoinRightsVO {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Long key;
    private Integer rolesId;
    private String[] showed;
    private Integer rightsId;
    private String intro;
    private Integer zaishoku;
    private String avatar;
    private RightsVO rights;
}
