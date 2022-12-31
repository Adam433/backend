package com.renkaen.cat_hospital.service;

import com.renkaen.cat_hospital.bean.DTO.PermissionJoinPermissionColumnDTO;
import com.renkaen.cat_hospital.bean.VO.RolePermissionVO;

import java.util.List;

public interface RolePermissionService {
    RolePermissionVO getPermissionByRolesId(int rolesId);
}
