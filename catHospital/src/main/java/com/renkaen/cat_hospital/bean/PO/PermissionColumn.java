package com.renkaen.cat_hospital.bean.PO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PermissionColumn {
    private int permissionColumnId;
    private String permissionColumnName;
    private String rootUrl;
}
