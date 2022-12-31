package com.renkaen.cat_hospital.bean.PO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Permission {
    private int permissionId;
    private String permissionName;
    private int permissionColumnId;
    private String url;
}
