package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.bean.VO.RightVO;
import lombok.Data;

import java.util.List;

@Data
public class RolesJoinPermissionDTO {
    private Integer roleId;
    private String katagaki;
    private String roleName;
    private List<Permission> permissionList;
}
