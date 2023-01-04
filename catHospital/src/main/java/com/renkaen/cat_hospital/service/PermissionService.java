package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DO.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getPermissionByRolesId(int rolesId);
}
