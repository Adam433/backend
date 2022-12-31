package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.PO.Rights;
import lombok.Data;

@Data
public class StaffJoinRightsDTO {
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
    private Rights rights;
}
