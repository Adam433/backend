package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.PO.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffVO {
    public StaffVO(Staff staff){
        if(staff!=null){
        this.id = staff.getId();
        this.username = staff.getUsername();
        this.password = staff.getPassword();
        this.name = staff.getRealName();
        this.key = staff.getKeyTime();
        this.rolesId = staff.getRolesId();
        this.rightsId = staff.getRightsId();
        this.intro = staff.getIntro();
        this.zaishoku = staff.getZaishoku();
        this.avatar = staff.getAvatar();
        this.showed = staff.getShowed().split(",");}
    }
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
}