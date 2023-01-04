package com.renkaen.cat_hospital.bean.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private int permissionId;
    private String permissionName;
    private int permissionColumn;
    private String url;
    private List<Permission> children;
}
