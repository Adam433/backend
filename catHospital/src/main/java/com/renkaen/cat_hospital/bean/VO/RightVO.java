package com.renkaen.cat_hospital.bean.VO;

import com.renkaen.cat_hospital.bean.DO.Permission;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RightVO {
    public RightVO(Permission permission,List<String> permissionList){
        id = permission.getPermissionId();
        title = permission.getPermissionName();
        key = permission.getUrl();
        right = permissionList.contains(permission.getUrl())?1:0;
        rank = permission.getPermissionColumn()==0?1:2;
    }
    private Integer id;
    private Integer fatherId;
    private String title;
    private String key;
    private Integer right;
    private Integer rank;
    private List<RightVO> children;
}
