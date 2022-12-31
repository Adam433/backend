package com.renkaen.cat_hospital.service.impl;

import com.renkaen.cat_hospital.bean.DTO.PermissionJoinPermissionColumnDTO;
import com.renkaen.cat_hospital.bean.VO.RolePermissionVO;
import com.renkaen.cat_hospital.mapper.RolePermissionMapper;
import com.renkaen.cat_hospital.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Override
    public RolePermissionVO getPermissionByRolesId(int rolesId) {
        RolePermissionVO rolePermissionVO = new RolePermissionVO();
        rolePermissionVO.setId(rolesId);
        rolePermissionVO.setRights(rolePermissionMapper.selectPermissionByRolesId(rolesId));
        return rolePermissionVO;
    }
}
