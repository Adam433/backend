package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DTO.PermissionJoinPermissionColumnDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionMapper {
    List<PermissionJoinPermissionColumnDTO>  selectPermissionByRolesId (int rolesId);
}
