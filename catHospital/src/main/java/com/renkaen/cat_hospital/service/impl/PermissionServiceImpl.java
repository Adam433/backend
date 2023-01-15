package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.mapper.PermissionMapper;
import com.renkaen.cat_hospital.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
}
