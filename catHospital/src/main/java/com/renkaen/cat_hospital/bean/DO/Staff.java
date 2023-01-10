package com.renkaen.cat_hospital.bean.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private Integer staffId;
    private String username;
    private String password;
    private String realName;
    private Long key;
    private Integer roleId;
    private String showed;
    private String intro;
    private Integer zaishoku;
    private String avatar;
}
