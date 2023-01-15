package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.bean.VO.RightVO;
import com.renkaen.cat_hospital.bean.VO.StaffJoinRightsVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class StaffJoinPermissionDTO {
    public StaffJoinPermissionDTO(StaffJoinRightsVO staffJoinRightsVO){
        List<Permission> list = new ArrayList<>();
        for (RightVO right : staffJoinRightsVO.getRights()) {
            list.add(new Permission(right));
        }
        staffId= staffJoinRightsVO.getId();
        username= staffJoinRightsVO.getUsername();
        password= staffJoinRightsVO.getPassword();
        realName= staffJoinRightsVO.getName();
        key= staffJoinRightsVO.getKey();
        katagaki= staffJoinRightsVO.getKatagaki();
        intro= staffJoinRightsVO.getIntro();
        zaishoku= staffJoinRightsVO.getZaishoku();
        avatar= staffJoinRightsVO.getAvatar();
        permissionList=list;
    }
    private Integer staffId;
    private String username;
    private String password;
    private String realName;
    private Long key;
    private List<String> katagaki;
    private String intro;
    private Integer zaishoku;
    private String avatar;
    private List<Permission> permissionList;
}
