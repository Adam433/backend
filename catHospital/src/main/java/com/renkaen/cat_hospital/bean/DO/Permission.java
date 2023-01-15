package com.renkaen.cat_hospital.bean.DO;

import com.renkaen.cat_hospital.bean.VO.RightVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    public Permission(RightVO rightVO){
        permissionId = rightVO.getId();
        permissionName = rightVO.getTitle();
        permissionColumn = rightVO.getFatherId();
        url = rightVO.getKey();
    }
    private int permissionId;
    private String permissionName;
    private int permissionColumn;
    private String url;
    private List<Permission> children;
}
