package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.bean.DTO.RolesJoinPermissionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class RolesJoinRightsVO {
    public RolesJoinRightsVO(RolesJoinPermissionDTO rolesJoinPermissionDTO, List<Permission> permissionAll) {
        if (rolesJoinPermissionDTO != null) {
            List<String> rightUrlList = new ArrayList<>();
            //permissions
            List<Permission> permissions = rolesJoinPermissionDTO.getPermissionList();
            //permissionVO
            List<RightVO> rightVOS = new ArrayList<>();
            //权限允许的url
            for (Permission permission : permissions) {
                rightUrlList.add(permission.getUrl());
            }
            //将权限进行分级
            permissionAll.forEach(root -> {
                if (root.getPermissionColumn() == 0) {
                    RightVO rightVO = new RightVO(root, rightUrlList);
                    List<RightVO> children = new ArrayList<>();
                    permissionAll.forEach(child -> {
                        if (child.getPermissionColumn() == root.getPermissionId()) {
                            children.add(new RightVO(child, rightUrlList));
                        }
                    });
                    rightVO.setChildren(children);
                    rightVOS.add(rightVO);
                }
            });
            id = rolesJoinPermissionDTO.getRoleId();
            katagaki = rolesJoinPermissionDTO.getKatagaki();
            roleName = rolesJoinPermissionDTO.getRoleName();
            key = rolesJoinPermissionDTO.getRoleId();
            rights = rightVOS;
        }
    }

    private Integer id;
    private String katagaki;
    private String roleName;
    private Integer key;
    private List<RightVO> rights;
}
