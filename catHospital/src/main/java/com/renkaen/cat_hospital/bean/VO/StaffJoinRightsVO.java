package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.bean.DTO.StaffJoinPermissionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class StaffJoinRightsVO {
    public StaffJoinRightsVO(StaffJoinPermissionDTO staffJoinPermissionDTO, List<Permission> permissionAll) {
        if (staffJoinPermissionDTO != null) {
            //showed
            List<String> rightUrlList = new ArrayList<>();
            //permissions
            List<Permission> permissions = staffJoinPermissionDTO.getPermissionList();
            //permissionVO
            List<RightVO> rightVOS = new ArrayList<>();
            //权限允许的url
            for (Permission permission : permissions) {
                rightUrlList.add(permission.getUrl());
            }
            //将权限进行分级
            permissionAll.forEach(root->{
                if(root.getPermissionColumn()==0){
                    RightVO rightVO = new RightVO(root,rightUrlList);
                    List<RightVO> children = new ArrayList<>();
                    permissionAll.forEach(child->{
                        if(child.getPermissionColumn()==root.getPermissionId()){
                            children.add(new RightVO(child,rightUrlList));
                        }
                    });
                    rightVO.setChildren(children);
                    rightVOS.add(rightVO);
                }
            });

            id = staffJoinPermissionDTO.getStaffId();
            username = staffJoinPermissionDTO.getUsername();
            password = staffJoinPermissionDTO.getPassword();
            name = staffJoinPermissionDTO.getRealName();
            key = staffJoinPermissionDTO.getKey();
            katagaki = staffJoinPermissionDTO.getKatagaki();
            rightsId = staffJoinPermissionDTO.getStaffId();
            intro = staffJoinPermissionDTO.getIntro();
            zaishoku = staffJoinPermissionDTO.getZaishoku();
            avatar = staffJoinPermissionDTO.getAvatar();
            this.rightUrlList = rightUrlList;
            rights = rightVOS;
        }
    }

    private Integer id;
    private String username;
    private String password;
    private String name;
    private Long key;
    private List<String> katagaki;
    private List<String> rightUrlList;
    private List<String> showed;
    private Integer rightsId;
    private String intro;
    private Integer zaishoku;
    private String avatar;
    private List<RightVO> rights;
}
