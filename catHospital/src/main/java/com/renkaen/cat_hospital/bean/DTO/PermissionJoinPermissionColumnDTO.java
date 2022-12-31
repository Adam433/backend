package com.renkaen.cat_hospital.bean.DTO;

import com.renkaen.cat_hospital.bean.PO.PermissionColumn;
import lombok.Data;

@Data
public class PermissionJoinPermissionColumnDTO {
    private int permissionId;
    private String permissionName;
    private int permissionColumnId;
    private String url;
    private PermissionColumn permissionColumn;
}
