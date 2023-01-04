package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.mapper.PermissionMapper;
import com.renkaen.cat_hospital.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getPermissionByRolesId(int rolesId) {

        return null;
    }
}
