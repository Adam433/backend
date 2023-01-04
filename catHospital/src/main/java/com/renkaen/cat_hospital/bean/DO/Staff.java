package com.renkaen.cat_hospital.bean.DO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Staff {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private Long keyTime;
    private Integer rolesId;
    private String showed;
    private Integer rightsId;
    private String intro;
    private Integer zaishoku;
    private String avatar;

    public Staff() {

    }
}
