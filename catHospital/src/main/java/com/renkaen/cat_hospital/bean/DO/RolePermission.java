package com.renkaen.cat_hospital.bean.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolePermission {
    private int id;
    private int rolesId;
    private int permissionId;
}
