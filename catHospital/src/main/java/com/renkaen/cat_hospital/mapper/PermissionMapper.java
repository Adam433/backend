package com.renkaen.cat_hospital.mapper;

import com.renkaen.cat_hospital.bean.DO.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<Permission>  selectPermissionByRolesId (int rolesId);
}
